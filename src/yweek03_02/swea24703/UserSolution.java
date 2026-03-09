package yweek03_02.swea24703;

import java.util.HashMap;
import java.util.Map;

class UserSolution {

    int n, width, height;
    int[][] tankHeight = new int[20][10005]; // 현재 쌓이 높이
    int[][] tankUpShape = new int[20][10005]; // 맨 위 결합판 모양
    Map<Integer, Integer> boll = new HashMap<>();
    int[] realId = new int[20];

    // 물 저장
    // int[][] storewater = new int[][];
    // 어항 id,

    public void init(int N, int mWidth, int mHeight, int mIDs[], int mLengths[][], int mUpShapes[][]) {
        n = N;
        width = mWidth;
        height = mHeight;

        boll.clear(); // map 초기화


        for(int i=0; i<n; i++){
            boll.put(mIDs[i], i); // 인덱스로 압축
            realId[i] = mIDs[i];

            // 2차원 배열은 얕은 복사말고 깊은 복사 해줘야함
            for(int j=0; j<width; j++){
                tankHeight[i][j] = mLengths[i][j];
                tankUpShape[i][j] = mUpShapes[i][j];
            }
        }
//        tankHeight = mLengths;
//        tankUpShape = mUpShapes;

    }

    // 10000회 호출
    // 주어진 구조물들을 설치할 수 있는 위치들의 수를 반환
    public int checkStructures(int mLengths[], int mUpShapes[], int mDownShapes[]) {
        // checkStructures({3, 3, 3}, {1, 0, 2}, {0, 1, 1})

        // 위치 수
        int count = 0;

        // 모든 어항 검사
        for(int tankIdx = 0; tankIdx<n; tankIdx++){
            for(int c = 0; c < width-2; c++){
                boolean chk = true;

                for(int j=0; j<3; j++){
                    int targetCol = c+j;

                    if(tankUpShape[tankIdx][targetCol] != mDownShapes[j]){
                        chk = false;
                        break;
                    }
                    if(tankHeight[tankIdx][targetCol] + mLengths[j] > height){
                        chk = false;
                        break;
                    }
                }
                if(!chk) continue;

                // 인접한 구조물들
                for(int i=0; i<2; i++){
                    int targetCol = c + i;
                    int minnum = Math.min(tankHeight[tankIdx][targetCol] + mLengths[i],tankHeight[tankIdx][targetCol+1] + mLengths[i+1]);
                    int maxnum = Math.max(tankHeight[tankIdx][targetCol], tankHeight[tankIdx][targetCol+1]);
                    if(maxnum>=minnum){
                        chk = false;
                        break;
                    }
                }
                if(chk){
                    count++;
                }
            }
        }
        return count;
    }

    // 1000회 호출
    // 구조물 설치, 설치한 어항의 ID와 설치한 열 위치 반환
    public int addStructures(int mLengths[], int mUpShapes[], int mDownShapes[]) {
        // 1. 최고의 위치를 기억할 변수들 (처음엔 아주 큰 값으로 세팅)
        int bestId = 2_000_000_000; // 문제에서 어항 ID 최댓값보다 큰 무한대 값
        int bestCol = 10005;        // 가장 왼쪽(작은 열)을 찾기 위해 무한대 세팅
        int bestTankIdx = -1;       // 우리가 찾은 최고의 어항 인덱스 (0~19)

        // 2. checkStructures와 완벽하게 똑같은 3중 탐색!
        for (int tankIdx = 0; tankIdx < n; tankIdx++) {
            for (int c = 0; c < width - 2; c++) {
                boolean chk = true;

                // 규칙 1 & 규칙 2 (결합판, 천장 검사)
                for (int j = 0; j < 3; j++) {
                    int targetCol = c + j;
                    if (tankUpShape[tankIdx][targetCol] != mDownShapes[j]) {
                        chk = false; break;
                    }
                    if (tankHeight[tankIdx][targetCol] + mLengths[j] > height) {
                        chk = false; break;
                    }
                }
                if (!chk) continue;

                // 규칙 3 (인접 구조물 겹침 검사)
                for (int i = 0; i < 2; i++) {
                    int targetCol = c + i;
                    int bottom1 = tankHeight[tankIdx][targetCol];
                    int top1 = bottom1 + mLengths[i];
                    int bottom2 = tankHeight[tankIdx][targetCol + 1];
                    int top2 = bottom2 + mLengths[i + 1];

                    // 안 겹치면 탈락!
                    if (Math.max(bottom1, bottom2) >= Math.min(top1, top2)) {
                        chk = false; break;
                    }
                }

                // =========================================================
                // 🚀 3. 여기가 핵심! 3가지 조건을 모두 통과한 설치 가능 위치라면?
                // =========================================================
                if (chk) {
                    int currentRealId = realId[tankIdx]; // 이 어항의 원래 ID

                    // [우선순위 1] 어항 ID가 더 작다면 무조건 갱신!
                    if (currentRealId < bestId) {
                        bestId = currentRealId;
                        bestCol = c;
                        bestTankIdx = tankIdx;
                    }
                    // [우선순위 2] 어항 ID는 같은데(사실 같은 일은 없지만), 열이 더 왼쪽(작다)이라면 갱신!
                    else if (currentRealId == bestId && c < bestCol) {
                        bestCol = c;
                        bestTankIdx = tankIdx;
                    }
                }
            }
        }

        // =========================================================
        // 🛠️ 4. 모든 어항을 다 뒤졌다! 최고 위치에 실제로 블록을 쌓자!
        // =========================================================
        if (bestTankIdx != -1) { // 설치할 곳을 한 곳이라도 찾았다면
            for (int j = 0; j < 3; j++) {
                int targetCol = bestCol + j;

                // 높이 올려주기! (기존 높이 + 새 구조물 높이)
                tankHeight[bestTankIdx][targetCol] += mLengths[j];

                // 맨 위 결합판 모양 덮어쓰기! (새 구조물의 윗부분 모양으로)
                tankUpShape[bestTankIdx][targetCol] = mUpShapes[j];
            }
            return bestId;
        }

        return 0;
    }

    // 100회 호출
    public Solution.Result pourIn(int mWater) {
        Solution.Result best = new Solution.Result();
        best.ID = 0;
        best.height = 0;
        best.used = 0;

        // 1. 모든 어항을 하나씩 검사합니다.
        for (int i = 0; i < n; i++) {

            // 2. 이 어항에서 1층부터 꼭대기층(height)까지 물을 채워봅니다.
            for (int h = 1; h <= height; h++) {
                int needWater = 0; // 높이 h까지 채우기 위해 필요한 물의 총량

                // 모든 열(column)을 돌면서 비어있는 칸을 더합니다.
                for (int c = 0; c < width; c++) {
                    if (tankHeight[i][c] < h) {
                        needWater += (h - tankHeight[i][c]); // 빈 공간만큼 물 추가!
                    }
                }

                // 3. 조건 검사: 물은 1 이상 써야 하고, 가진 물(mWater)보단 적거나 같아야 함!
                if (needWater >= 1 && needWater <= mWater) {

                    boolean isBetter = false;

                    // [우선순위 1] 높이가 더 높은가?
                    if (h > best.height) {
                        isBetter = true;
                    }
                    // [우선순위 2] 높이는 같은데, 물을 더 많이 썼나?
                    else if (h == best.height) {
                        if (needWater > best.used) {
                            isBetter = true;
                        }
                        // [우선순위 3] 높이도, 물의 양도 같은데 어항 ID가 더 작나?
                        else if (needWater == best.used) {
                            if (realId[i] < best.ID) { // 🚨 주의: realId 배열 필요!
                                isBetter = true;
                            }
                        }
                    }

                    // 4. 지금 찾은 조건이 기존 '최고'보다 좋다면 갱신!
                    if (isBetter) {
                        best.height = h;
                        best.used = needWater;
                        best.ID = realId[i];
                    }
                }
            }
        }

        // 조건에 맞는 어항이 하나도 없었다면 초기값(0, 0, 0)이 리턴됩니다.
        return best;
    }
}

// 어항의 Id : 최대 100만 -> 어항 개수는 최대 20 -> HashMap으로 관리
// 결합판의 종류 : 0~3
// 물의 양 : ~3000
