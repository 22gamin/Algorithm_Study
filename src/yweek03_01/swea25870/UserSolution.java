package yweek03_01.swea25870;


import java.util.ArrayList;

class UserSolution {
    int n;
    int shareFilecnt[];
    int fileId[][];
    int fileSize[][];
    int time;

    // 연결리스트
    ArrayList<ArrayList<int[]>> al = new ArrayList<>();

    void init(int N, int mShareFileCnt[], int mFileID[][], int mFileSize[][])
    {
        n = N;
        shareFilecnt = mShareFileCnt;
        fileId = mFileID;
        fileSize = mFileSize;

        // 현재 시각은 0
        time = 0;

        al = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            al.add(new ArrayList<>());
        }
    }

    void makeNet(int K, int mComA[], int mComB[], int mDis[])
    {
        int k = K;
        for(int i=0; i<k; i++){
            al.get(mComA[i]).add(new int[]{mComB[i], mDis[i]});
            al.get(mComB[i]).add(new int[]{mComA[i], mDis[i]});
        }

    }

    void addLink(int mTime, int mComA, int mComB, int mDis)
    {

    }

    void addShareFile(int mTime, int mComA, int mFileID, int mSize)
    {
    }

    int downloadFile(int mTime, int mComA, int mFileID)
    {
        return 0;
    }

    int getFileSize(int mTime, int mComA, int mFileID)
    {
        return 0;
    }
}