package yweek03_01.swea25870;


import java.util.ArrayList;
import java.util.HashMap;

class UserSolution {
    int n;
    int shareFilecnt[];
    int fileId[][];
    int fileSize[][];
    int time;

    // 연결리스트
    ArrayList<ArrayList<int[]>> al = new ArrayList<>();

    // Id 압축
    HashMap<Integer, Integer> fileMap;
    int fileIdx;

    boolean[][] hasFile;

    void init(int N, int mShareFileCnt[], int mFileID[][], int mFileSize[][])
    {
        n = N;
        shareFilecnt = mShareFileCnt; // 공유파일의 개수
        fileId = mFileID;
        fileSize = mFileSize;

        // 현재 시각은 0
        time = 0;

        al = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            al.add(new ArrayList<>());
        }

        fileMap = new HashMap<>();
        fileIdx = 0;
        for(int i=0; i<n; i++){
            int comIdx = i+1;
            for(int k = 0; k<mShareFileCnt[i]; k++){
                int originalFileId = mFileID[i][k];

                if(!fileMap.containsKey(originalFileId)){
                    fileMap.put(originalFileId, fileIdx);
                    fileIdx++;
                }

                int compressedId = fileMap.get(originalFileId);
                hasFile[comIdx][compressedId] = true;
            }
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