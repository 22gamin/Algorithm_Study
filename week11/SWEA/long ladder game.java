import java.util.*;


class UserSolution
{	
	static TreeSet<int []>[] ladder ;
	static HashMap<Integer, int []>[] map;
	

	
	@SuppressWarnings("unchecked")
	public void init()
	{
		ladder = new TreeSet[101];
		map = new HashMap[101];
		for(int i =1; i<=100; i++) {
			ladder[i] = new TreeSet<int[]>((a,b)->{
				return a[1]-b[1];
			});
		}
		
		for(int i = 1; i<=100; i++) {
			map[i] = new HashMap<Integer,int[]>();
		}
		
	}

	public void add(int mX, int mY)
	{
		int[] l1 = new int[] {1,mY};	
		int[] l2 =new int[] {-1,mY};
		
		ladder[mX].add(l1);
		map[mX].put(mY, l1);
		ladder[mX+1].add(l2);
		map[mX+1].put(mY, l2);
		
	}

	public void remove(int mX, int mY)
	{
		int[] l1 = map[mX].get(mY);
		int nx = mX+1; 
		
		if(l1[0]==-1) {
			nx = mX-1;
		}
		
		int[] l2 = map[nx].get(mY);
		
		map[mX].remove(mY);
		map[nx].remove(mY);
		
		ladder[mX].remove(l1);
		ladder[nx].remove(l2);
		
	}	

	public int numberOfCross(int mID)
	{	
		int x = mID;
		if(ladder[mID].isEmpty()) {
			return 0;
		}
		
		int[] next = ladder[mID].first();
		int count =1;
		
		while(true) {
			
			if(next[0]==-1) {
				x--;
				if(ladder[x].isEmpty()) return count;
				next = ladder[x].higher(next);	
				if(next == null) return count;
				count++;
			
			}else {
				x++;
				if(ladder[x].isEmpty()) return count;		
				next = ladder[x].higher(next);			
				if(next == null) return count;
				
				count++;
				
			}
				
		}
		
	}

	public int participant(int mX, int mY)
	{
		int x =  mX;
		int[] next = new int[] {0,mY};
		next = ladder[x].lower(next);	
		while(true) {
				
			if(next== null) return x;		
			if(next[0]==-1) {
				x--;
				next = ladder[x].lower(next);
			}else {
				x++;
				next = ladder[x].lower(next);
			}
			
			
		}
		
		
	}
}
