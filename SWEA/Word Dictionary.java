import java.util.*;

class UserSolution {
	int n ;
	Node root;
	StringBuilder result;
	class Node{
		char value;
		boolean isE;
		int cnt;
		Node [] child;
	
		Node(){
			this.child = new Node[26];
			this.cnt =0;
			this.isE = false;
		}
	}
	void remove(String a) {
		Node current  = root;
		for(int i = 0 ; i <a.length(); i++) {
			char c = a.charAt(i);
			int index = c-'a';
			current =current.child[index];
			current.cnt--;
		}
		current.isE = false;
	}
	
	void insert(String a) {
		Node current  = root;
		for(int i = 0 ; i <a.length(); i++) {
			char c = a.charAt(i);
			int index = c-'a';
			if(current.child[index]==null ) {
				current.child[index]= new Node();
			}
			
			current = current.child[index];
			current.value = c;
			current.cnt++;
		}
		current.isE = true;
	}
	
	void init(int N, String mWordList[], int mWordSize)
	{	root = new Node();
		
		n = N;
		for (int i = 0; i < mWordSize; i++) {
		    insert(mWordList[i]);
		}

	}

	void addWord(String mWordList[], int mWordSize)
	{
		for (int i = 0; i < mWordSize; i++) {
		    insert(mWordList[i]);
		}
	}

	void removeWord(String mWordList[], int mWordSize)
	{
		for (int i = 0; i < mWordSize; i++) {
		    remove(mWordList[i]);
		}
	}

	
	String findWord(int mPageNum)
	{	int k = (mPageNum-1)*n +1;
		StringBuilder sb = new StringBuilder();
		Node current = root;
		while(true) {
			if(current != root) {
				sb.append(current.value);
				if(current.isE) {
					k--;
				}
				if(k==0) break;
			}
			
			for(int i = 0 ; i <26; i ++) {
				Node nd = current.child[i];
				if(nd==null) continue;
				if(nd.cnt >=k) {
					current = nd;
					break;
				}
				
				k-=nd.cnt;
			}
			
		}
		
		String mRet = new String();
		mRet = sb.toString();
		return mRet;
	}

	int findPage(String mWord)
	{	
		int count = 0 ; 
		Node current = root;
		for(int i = 0 ; i<mWord.length(); i++) {
			char c = mWord.charAt(i);
			for(int j = 0  ; j < 26 ; j ++) {
				if(current.child[j]==null) continue;
				if(current.child[j].value==c) {
					current = current.child[j];
					if(current.isE) count++;
					break;
				}
				count+=current.child[j].cnt;
			}
			
		}
		
		
		int result = 0;
		if(count%n ==0) {
			result = count/n;
		}else {
			result = count/n +1;
		}
		return result;
	}
}
