package yweek02_04;


import java.util.ArrayList;

class UserSolution {
    int n;
    int shareFilecnt[];
    int fileId[][];
    int fileSize[][];

    // 연결리스트
    ArrayList<ArrayList<int[]>> al = new ArrayList<>();

    void init(int N, int mShareFileCnt[], int mFileID[][], int mFileSize[][])
    {
        n = N;
        shareFilecnt = mShareFileCnt;
        fileId = mFileID;

        // 현재 시각은 0




    }

    void makeNet(int K, int mComA[], int mComB[], int mDis[])
    {
        for(int i=0; i<K; i++){
            al.add(new ArrayList<>());
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