import java.util.*;

class UserSolution {

    class Pic {
        int sz;
        int[][] sum;

        public Pic(int mSize, int mCnt, int mPixel[][3]) {
            this.sz = mSize;
            
            int[][] img = new int[mSize][mSize];
            for (int i = 0; i < mCnt; i++) {
                img[mPixel[i][0]][mPixel[i][1]] = mPixel[i][2];
            }

            this.sum = new int[mSize + 1][mSize + 1];
            for (int r = 1; r <= mSize; r++) {
                for (int c = 1; c <= mSize; c++) {
                    sum[r][c] = img[r - 1][c - 1]
                                + sum[r - 1][c]
                                + sum[r][c - 1]
                                - sum[r - 1][c - 1];
                }
            }
        }

        public int query(int r1, int c1, int r2, int c2) {
            r1++; c1++; r2++; c2++;
            
            return sum[r2][c2]
                 - sum[r1 - 1][c2]
                 - sum[r2][c1 - 1]
                 + sum[r1 - 1][c1 - 1];
        }
    }

    class Cmd {
        int id;
        int r, c, dir;

        public Cmd(int mID, int mRow, int mCol, int mDir) {
            this.id = mID;
            this.r = mRow;
            this.c = mCol;
            this.dir = mDir;
        }

        @Override
        public int hashCode() {
            return id + r * 31 + c * 31 * 31 + dir;
        }

        @Override
        public boolean equals(Object obj) {
            Cmd other = (Cmd) obj;
            return id == other.id && r == other.r && c == other.c && dir == other.dir;
        }
    }
    
    HashMap<Integer, Pic> pics;
    ArrayList<Cmd>[][] grid;
    int gSize;
    
    public void init(int N) {
        pics = new HashMap<>();

        gSize = (N + 24) / 25;
        grid = new ArrayList[gSize][gSize];

        for (int i = 0; i < gSize; i++) {
            for (int j = 0; j < gSize; j++) {
                grid[i][j] = new ArrayList<>();
            }
        }
    }

    public void addPrint(int mID, int mSize, int mCnt, int mPixel[][3]) {
        Pic p = new Pic(mSize, mCnt, mPixel);
        pics.put(mID, p);
    }
    
    
    
    

    public void pressPrint(int mID, int mRow, int mCol, int mDir) {
        Cmd cmd = new Cmd(mID, mRow, mCol, mDir);
        int sz = pics.get(mID).sz;

        int sr = mRow / 25;
        int er = (mRow + sz - 1) / 25;
        int sc = mCol / 25;
        int ec = (mCol + sz - 1) / 25;

        for (int r = sr; r <= er; r++) {
            for (int c = sc; c <= ec; c++) {
                if (r >= gSize || c >= gSize) continue;
                grid[r][c].add(cmd);
            }
        }
    }

    private int getSum(Cmd cmd, int qr, int qc) {
    
    
    
        Pic t = pics.get(cmd.id);
        int sz = t.sz;
        int dir = cmd.dir;
        
        int qr1 = qr;
        int qc1 = qc;
        int qr2 = qr + 24;
        int qc2 = qc + 24;

        int pr1 = cmd.r;
        int pc1 = cmd.c;
        int pr2 = cmd.r + sz - 1;
        int pc2 = cmd.c + sz - 1;

        int ir1 = Math.max(qr1, pr1);
        int ic1 = Math.max(qc1, pc1);
        int ir2 = Math.min(qr2, pr2);
        int ic2 = Math.min(qc2, pc2);

        if (ir1 > ir2 || ic1 > ic2) {
            return 0;
        }

        int lr1 = ir1 - pr1;
        int lc1 = ic1 - pc1;
        int lr2 = ir2 - pr1;
        int lc2 = ic2 - pc1;

        int r1, c1, r2, c2;
        int S = sz - 1;

        switch (dir) {
            case 0:
                r1 = lr1; c1 = lc1;
                r2 = lr2; c2 = lc2;
                break;
            case 1:
                r1 = lc1; c1 = S - lr2;
                r2 = lc2; c2 = S - lr1;
                break;
            case 2:
                r1 = S - lr2; c1 = S - lc2;
                r2 = S - lr1; c2 = S - lc1;
                break;
            case 3:
                r1 = S - lc2; c1 = lr1;
                r2 = S - lc1; c2 = lr2;
                break;
            default:
                return 0;
        }

        return t.query(r1, c1, r2, c2);
    }
    
    public int getDepth(int mRow, int mCol) {
    
    
        int sum = 0;
        int sr = mRow / 25;
        int sc = mCol / 25;

        HashSet<Cmd> visit = new HashSet<>();
        
        
        

        for (int r = sr; r <= sr + 1; r++) {
            for (int c = sc; c <= sc + 1; c++) {
                if (r >= gSize || c >= gSize) continue;

                for (Cmd cmd : grid[r][c]) {
                    if (visit.contains(cmd)) continue;
                    visit.add(cmd);
                    sum += getSum(cmd, mRow, mCol);
                }
            }
        }
        
        
        
        
        
        
        
        return sum;
    }
}
