import java.util.*;

class UserSolution {

    static class Word implements Comparable<Word> {
        String value;
        Word (String value){
            this.value = value;
        }

        @Override
        public int compareTo(Word o) {
            return this.value.compareTo(o.value);
        };
    }
    
    static class Person{
    	int prev;
    	int next;
    	int num;
    	
    	Person(int num, int prev, int next){
    		this.num = num;
    		this.prev = prev;
    		this.next = next;
    	}
    }
    
    
    static Set<String> usedWords ;
    static Person[] people;
    static PriorityQueue<Word>[] words;
   
 
    @SuppressWarnings("unchecked")
    public void init(int N, int M, char[][] mWords)
    {
    	usedWords= new HashSet<>();
    	
        words = new PriorityQueue[26];
        for (int i = 0; i < 26; i++) {
            words[i] = new PriorityQueue<>(); 
        }
        
        people=  new Person[N+1];
        for(int i = 1; i<=N;i++) {
        	if(i==1) {
        		people[i] = new Person(i,N,2);
        	}else if(i==N) {
        		people[i] = new Person(i,i-1,1);
        	}else {
        		people[i] = new Person(i,i-1,i+1);
        	}
        }
        
        
        for(int i = 0; i<M; i++) {
            int index = mWords[i][0]-'a';
            
       
            int len = 0;
            while(len < mWords[i].length && mWords[i][len] != '\0') {
                len++;
            }
            String x = new String(mWords[i], 0, len);
          
            words[index].offer(new Word(x));
        }
    }
    
    

   
    public int playRound(int mID, char mCh)
    {            
        List<String> wordsThisRound = new ArrayList<>();

        while(true) {
            int index = mCh - 'a';
                       
            if(words[index].isEmpty()) {
                int loserID = mID;
                                
              people[people[loserID].prev].next = people[loserID].next;
            	people[people[loserID].next].prev = people[loserID].prev;
            	            	
                for (String usedWord : wordsThisRound) {                  
                    String reversedWord = new StringBuilder(usedWord).reverse().toString();
         
                    if (!usedWords.contains(reversedWord)) {
                        int revIndex = reversedWord.charAt(0) - 'a';
                        words[revIndex].offer(new Word(reversedWord));
                    }
                }
         
            	return loserID;
            }
            
            
         
            Word now = words[index].poll();
            String nowWord = now.value;
            
            
            if(usedWords.contains(nowWord)) {
            	continue;
            }
            
            
            

            usedWords.add(nowWord);     
            wordsThisRound.add(nowWord); 
            
            
            mCh = nowWord.charAt(nowWord.length() - 1); 
            mID = people[mID].next; 
        }
    }
    
    
    
    
    
    
    
    
}

