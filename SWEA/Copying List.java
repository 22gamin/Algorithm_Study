package test;
import java.util.*;

class UserSolution
{	static final int Length = 200000;
	static int [][] initList ;
	Map<String,Integer> address;
	static int addressNum;
	static int logNum;
	static int[] prev;
	static int[] last;
	static int[][] changeLog;
	static int initNum;
	String getName(char mName[]) {
		String name="";
		for(int i = 0 ; mName[i] != 0; i++){
			name+=mName[i];
		}
		return name;
	}
	
	public void init()
	{	
		initNum = 0;
		addressNum=0;
		initList = new int[10][Length];
		address = new HashMap<>();
		logNum =0;
		prev = new int[110000];
		last = new int[5500];
		changeLog = new int[110000][2];
	}

	public void makeList(char mName[], int mLength, int mListValue[])
	{	String name = getName(mName);
		
		address.put(name,addressNum);
		System.arraycopy(mListValue, 0, initList[initNum], 0, mLength);
		
		changeLog[logNum][0] = -1;
		changeLog[logNum][1] = initNum;
		prev[logNum] = -1;
		last[addressNum]= logNum;
		
		logNum++;
		addressNum++;
		initNum++;
	}

	public void copyList(char mDest[], char mSrc[], boolean mCopy)
	{	String dest = getName(mDest);
		String src = getName(mSrc);
		
		int srcNum = address.get(src);
		
		if(mCopy) {
			address.put(dest,addressNum);
			changeLog[logNum][0] = -1;
			changeLog[logNum][1] = -1;
			last[addressNum] = logNum;
			prev[logNum] = last[srcNum];
			logNum++;
			addressNum++;
		}else {
			address.put(dest, srcNum);
		}
	}

	public void updateElement(char mName[], int mIndex, int mValue)
	{
		String name = getName(mName);
		int num = address.get(name);
		
		prev[logNum] = last[num];
		last[num] = logNum;
		changeLog[logNum][0] = mIndex;
		changeLog[logNum][1] = mValue;
		logNum++;
		
		
		
	}

	public int element(char mName[], int mIndex)
	{
		String name = getName(mName);
		int num = address.get(name);
		
		int c = last[num];
		while(true) {
			
			int a = changeLog[c][0];
			int b = changeLog[c][1];
			
			if(a==mIndex) {
				return b;
			}
			
			
			
			
			
			
			
			if(prev[c]==-1) {
				return initList[b][mIndex];
			}
			
			c = prev[c];
			
			
			
		}
		
		
		
		
		
	}
}
