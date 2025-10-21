import java.util.*;

class UserSolution {

    class Robot {
        int status;
        int id;
        long lastTime; 
        long iq;       

        Robot() {
            this.status = 0;
            this.id = rid;
            this.lastTime = 0;
            this.iq = 0;
            rid++;
        }
    }

    Robot[] robots;
    TreeSet<Robot> highIq;
    TreeSet<Robot> lowIq;
    int rid;
    LinkedList<Robot>[] workArea;

    public void init(int N) {
        rid = 1;

        highIq = new TreeSet<>((a, b) -> {
            int iqCompare = Long.compare(b.iq, a.iq);
            if (iqCompare != 0) return iqCompare;
            return Integer.compare(a.id, b.id);
        });

        lowIq = new TreeSet<>((a, b) -> {
            int iqCompare = Long.compare(a.iq, b.iq);
            if (iqCompare != 0) return iqCompare;
            return Integer.compare(a.id, b.id);
        });

        robots = new Robot[N + 1];
        workArea = new LinkedList[50001];

        for (int i = 1; i <= N; i++) {
            robots[i] = new Robot();
            highIq.add(robots[i]);
            lowIq.add(robots[i]);
        }

        for (int i = 0; i <= 50000; i++) {
            workArea[i] = new LinkedList<>();
        }
    }

    public int callJob(int cTime, int wID, int mNum, int mOpt) {
        int sum = 0;

        if (mOpt == 0) {
            for (int i = 0; i < mNum; i++) {
                Robot r = highIq.pollFirst();
                if (r == null) break;
                lowIq.remove(r);
                workArea[wID].add(r);
                r.lastTime = cTime;
                r.status = wID;
                sum += r.id;
            }
        } else {
            for (int i = 0; i < mNum; i++) {
                Robot r = lowIq.pollFirst();
                if (r == null) break;
                highIq.remove(r);
                workArea[wID].add(r);
                r.lastTime = cTime;
                r.status = wID;
                sum += r.id;
            }
        }

        return sum;
    }

    public void returnJob(int cTime, int wID) {
        while (!workArea[wID].isEmpty()) {
            Robot r = workArea[wID].get(0);
            if (r.status != wID) {
                workArea[wID].remove(0);
                continue;
            }
            r.iq += r.lastTime - cTime;
            r.status = 0;
            highIq.add(r);
            lowIq.add(r);
            workArea[wID].remove(0);
        }
    }

    public void broken(int cTime, int rID) {
        Robot r = robots[rID];
        if (r.status < 1) return;
        r.lastTime = cTime;
        r.status = -1;
    }

    public void repair(int cTime, int rID) {
        Robot r = robots[rID];
        if (r.status != -1) return;
        r.iq = -cTime;
        r.status = 0;
        highIq.add(r);
        lowIq.add(r);
    }

    public int check(int cTime, int rID) {
        Robot r = robots[rID];
        if (r.status == -1) return 0;
        if (r.status > 0) return -r.status;
        return (int) (r.iq + cTime);
    }

   
}
