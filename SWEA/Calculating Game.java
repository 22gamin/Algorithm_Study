import java.util.*;

class UserSolution {
	
	class Pack { //4개씩 관리할 팩 클래스 만듬
		int[] cards =new int[4];	
		Pack() {} 		
		
	}
	
	static int[][] allCards;
	static Deque<Pack>[][] packs ;
	static int joker;
	static Pack[] temp = new Pack[1000]; // 덱에서 poll한걸 임시로 담아놓을 배열
   
	@SuppressWarnings("unchecked")
	void init(int mJoker, int mNumbers[]) {
    	packs = new LinkedList[20][20]; // 조커 값에 따른 나머지 별로 관리할 덱
    	allCards = new int[2][5]; //나열된 카드 관리 배열  [0]은 마지막에 추가된 왼쪽 [1]은 마지막에 추가된 오른쪽
    	joker = mJoker; //조커 변수 초기화
    	
    	for(int i = 0; i<20; i++) { // 조커의 나머지값으로 ㄱㄱ
    		for(int j =0; j<20; j++) {
    			packs[i][j] = new LinkedList<>();
    		}
    	}
    	 	
    	for(int i=0; i<5; i++) {
    		allCards[0][i] = mNumbers[i]; //처음 추가니깐 오왼 둘다 이걸로
    		allCards[1][i] = mNumbers[i];
    	}
    	
    	
    	
    	for(int i =0; i<2; i++) {
    		
    		int sum = 0; 
        	int jokerNum = 0;
        	Pack pack =new Pack();
        	int pI = 0; // 팩 저장 인덱스 (4개짜리 카드 배열)
     	
    		for(int j=i; j<i+4; j++) {
    			pack.cards[pI] = mNumbers[j];
    			
    			if(mNumbers[j]!=-1) {
    				sum  += mNumbers[j];
    			}else {
    				jokerNum++;
    			}
    			
    			pI++;
    		}
    		
    		for(int j = 0; j<20; j++) {
        		int jokerSum = j * jokerNum; //조커값이 j일때 4개짜리 카드 총 조커합
        		int index = (sum+jokerSum)%20; //4개짜리 카드(팩)의 나머지
        		
        		packs[j][index].addLast(pack); //조커 값이 j일 경우 합의 20의 나머지가 index인 경우
        	}
    	}
    	
    	
    	
    
    	
    }

    
    void putCards(int mDir, int mNumbers[]) {
    	
    	if(mDir == 0) { //왼쪽 addFirst 갈겨야함 ㅇㅇ
    		
    		for(int i =4; i>=2; i--) {
    			int sum = 0; 
            	int jokerNum = 0;
            	Pack pack =new Pack();
            	int pI = 0; // 팩 저장 인덱스 (4개짜리 카드 배열)
            	
            	for(int j = i; j<i+4; j++) {
    				
        			
    				if(j>4) {
    					pack.cards[pI] = allCards[0][j-5];
    					if(allCards[0][j-5]!=-1) {
            				sum += allCards[0][j-5];
            			}else {
            				jokerNum++;
            			}  
    				}else {
    					pack.cards[pI] = mNumbers[j];
    					if(mNumbers[j]!=-1) {
            				sum  += mNumbers[j];
            			}else {
            				jokerNum++;
            			}  
    				}
        			      			
        			pI++;
    			}
            	for(int j = 0; j<20; j++) {
            		int jokerSum = j * jokerNum; //조커값이 j일때 4개짜리 카드 총 조커합
            		int index = (sum+jokerSum)%20; //4개짜리 카드(팩)의 나머지
            		
            		packs[j][index].addFirst(pack); //조커 값이 j일 경우 합의 20의 나머지가 index인 경우
            		if(packs[j][index].size()>1000) {
            			packs[j][index].pollLast();
            		}//1000번째 이후를 볼 일은 없으니 메모리를 아끼자.
            	}
            	
    		}
    		
    		for(int i = 1; i>=0; i--) {
    			//2개까지는 주어진 배열내에서 계산하고 packs에 넣자
    			int sum = 0; 
            	int jokerNum = 0;
            	Pack pack =new Pack();
            	int pI = 0; // 팩 저장 인덱스 (4개짜리 카드 배열)
            	
    			for(int j = i; j<i+4; j++) {
    				pack.cards[pI] = mNumbers[j];
        			
        			if(mNumbers[j]!=-1) {
        				sum  += mNumbers[j];
        			}else {
        				jokerNum++;
        			}        			
        			pI++;
    			}
    				
    			for(int j = 0; j<20; j++) {
            		int jokerSum = j * jokerNum; //조커값이 j일때 4개짜리 카드 총 조커합
            		int index = (sum+jokerSum)%20; //4개짜리 카드(팩)의 나머지
            		
            		packs[j][index].addFirst(pack); //조커 값이 j일 경우 합의 20의 나머지가 index인 경우
            		if(packs[j][index].size()>1000) {
            			packs[j][index].pollLast();
            		} //1000번째 이후를 볼 일은 없으니 메모리를 아끼자.
            	}
    			
    		} 
    		
    	
    		
    		for(int i = 0 ; i<5; i++) {
    			allCards[0][i] = mNumbers[i];
    		}
    		
    		
    	}else {
    		
    		
    		for(int i =2; i<5; i++) {//기존 오른쪽 배열의 2~4까지는 이렇게
    			int sum = 0; 
            	int jokerNum = 0;
            	Pack pack =new Pack();
            	int pI = 0; // 팩 저장 인덱스 (4개짜리 카드 배열)
    			for(int j = i; j<i+4; j++) {
    				if(j>4) {
    					pack.cards[pI] = mNumbers[j-5];
    					if(mNumbers[j-5]!=-1) {
            				sum  += mNumbers[j-5];
            			}else {
            				jokerNum++;
            			}  
    				}else {
    					pack.cards[pI] = allCards[1][j];
    					if( allCards[1][j]!=-1) {
            				sum += allCards[1][j];
            			}else {
            				jokerNum++;
            			}  
    				}			
        			pI++;
    			}
    			for(int j = 0; j<20; j++) {
            		int jokerSum = j * jokerNum; //조커값이 j일때 4개짜리 카드 총 조커합
            		int index = (sum+jokerSum)%20; //4개짜리 카드(팩)의 나머지
            		if(packs[j][index].size()>1000) continue; //1000번째 이후를 볼 일은 없으니 메모리를 아끼자.
            		packs[j][index].addLast(pack); //조커 값이 j일 경우 합의 20의 나머지가 index인 경우
            	}
    		}
    		
    		for(int i =0; i<2; i++) {
        		
        		int sum = 0; 
            	int jokerNum = 0;
            	Pack pack =new Pack();
            	int pI = 0; // 팩 저장 인덱스 (4개짜리 카드 배열)
         	
        		for(int j=i; j<i+4; j++) {
        			pack.cards[pI] = mNumbers[j];
        			
        			if(mNumbers[j]!=-1) {
        				sum  += mNumbers[j];
        			}else {
        				jokerNum++;
        			}
        			
        			pI++;
        		}
        		
        		for(int j = 0; j<20; j++) {
            		int jokerSum = j * jokerNum; //조커값이 j일때 4개짜리 카드 총 조커합
            		int index = (sum+jokerSum)%20; //4개짜리 카드(팩)의 나머지
            		if(packs[j][index].size()>1000) continue; //1000번째 이후를 볼 일은 없으니 메모리를 아끼자.
            		packs[j][index].addLast(pack); //조커 값이 j일 경우 합의 20의 나머지가 index인 경우
            	}
        	}
    		for(int i = 0 ; i<5; i++) {
    			allCards[1][i] = mNumbers[i];
    		}
    		
    	}
    
    }



    int findNumber(int mNum, int mNth, int ret[]) {
    	int index = 0; 
    	boolean isF = false;
    	
    	
    	while(!packs[joker%20][mNum].isEmpty()&index<1000) {
    		temp[index] = packs[joker%20][mNum].pollFirst();
    		if(index+1 == mNth) {
    			isF=true;
    			break;
    		}
    		
    		
    		index++;
    	}
    	
    	if(isF) {
    		for(int i = 0 ; i<4; i++) {
    			ret[i] = temp[index].cards[i];
    		}
    		
    		for(int i = index; i>=0; i--) {
    			packs[joker%20][mNum].addFirst(temp[i]);
    		}
    	
    		return 1;
    	}
    	for(int i = index-1; i>=0; i--) {
			packs[joker%20][mNum].addFirst(temp[i]);
		}
    	return 0;
    }
    
    void changeJoker(int mValue) {
    	joker = mValue;
    }
}
