package week12;

import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
        for(int i=0;i<players.length;i++){
            rank.put(players[i],i);
        }
        
        for(String name : callings){
            int idx = rank.get(name);
            
            String prev = players[idx-1];
            players[idx-1]=name;
            players[idx]=prev;
            
            rank.put(name,idx-1);
            rank.put(prev,idx);
        }
        return players;
    }
}