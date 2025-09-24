import java.util.*;

class UserSolution {
    static int n;
    static OrderClass[] orders; 
    static PriorityQueue<Integer>[] juice;
    static HashMap<Integer, Integer> getId;
    static TreeSet<OrderClass> ts;
    static int id;

    class OrderClass{
        int status;
        int size;
        int[] juices;
        int mid;
        int id;
        int[] placedJuice;

        OrderClass(int mid, int status, int size, int[] mBeverages) {
            this.status = status;
            this.size = size;
            this.mid = mid;
            juices = new int[n + 1];
            placedJuice = new int[n + 1];
            for (int x : mBeverages) {
                juices[x]++;
            }
            this.id = getId.get(mid);
        }

       
    }

    @SuppressWarnings("unchecked")
    public void init(int N) {
        id = 1;
        n = N; // 음료종류
        juice = new PriorityQueue[n + 1];
        for (int i = 0; i <= n; i++) {
            juice[i] = new PriorityQueue<>();
        }
        orders = new OrderClass[20001];
        getId = new HashMap<>();
        ts = new TreeSet<>((a, b) -> {
            if (a.size != b.size) {
                return b.size - a.size; // 1. size 내림차순
            }
            return a.id - b.id; // 2. size가 같으면 id 오름차순
        });
        return;
    }

    public int order(int mID, int M, int mBeverages[]) {
        getId.put(mID, id);
        OrderClass o = new OrderClass(mID, 1, M, mBeverages);
        orders[id] = o;
        for (int i = 0; i < M; i++) {
            int x = mBeverages[i];
            juice[x].offer(id);
        }
        id++;
        ts.add(o);
        return ts.size();
    }

    public int supply(int mBeverage) {
        if (juice[mBeverage].isEmpty()) {
            return -1;
        }

        int tid = juice[mBeverage].poll();

        while (!juice[mBeverage].isEmpty()) {
            if (orders[tid].status>0) break;
            tid = juice[mBeverage].poll();
        }

        if (orders[tid].status<=0) return -1;
        
        OrderClass o = orders[tid];
        ts.remove(o);
        o.size--;
        o.juices[mBeverage]--;
        o.placedJuice[mBeverage]++;
        if (o.size == 0) {
            o.status = 0;

        }else {
        	ts.add(o);
        }
        return o.mid;
    }

    public int cancel(int mID) {
        int tid = getId.get(mID);
        if (orders[tid].status>0) {
            OrderClass o = orders[tid];
           
            ts.remove(o);
            o.status = -1;

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < o.placedJuice[i]; j++) {
                    supply(i);
                }
            }

            int result = o.size;
            o.size = 0;
            return result;
        } else {
            return orders[tid].status;
        }
    }

    public int getStatus(int mID) {
        int tid = getId.get(mID);
        if (orders[tid].status>0) {
            return orders[tid].size;
        } else {
            return orders[tid].status;
        }
    }

    Solution.RESULT hurry() {
        Solution.RESULT res = new Solution.RESULT();
        res.cnt = 0;
        
        for (OrderClass o : ts) {
            if (res.cnt == 5) break;
            res.IDs[res.cnt++] = o.mid;
        }
        
        return res;
    }
}
