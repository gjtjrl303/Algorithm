import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        int[] answer = {0,0};
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int i = 0 ; i < operations.length ; i++){
            String[] split = operations[i].split(" ");
            Integer option = Integer.parseInt(split[1]);
            
            if(split[0].equals("I")){
                map.put(option, map.getOrDefault(option, 0) + 1);
            }else if(split[0].equals("D")){
                if(option == 1){
                    if(!map.isEmpty()){
                        Integer lastKey = map.lastKey();
                        map.put(lastKey, map.getOrDefault(lastKey, 0) - 1);
                        if(map.get(lastKey) == 0) map.remove(lastKey);
                    }
                }else if( option == -1){
                    if(!map.isEmpty()){
                        Integer firstKey = map.firstKey();
                        map.put(firstKey, map.getOrDefault(firstKey, 0) - 1);
                        if(map.get(firstKey) == 0) map.remove(firstKey);
                    }
                }
            }
        }
        
        if(!map.isEmpty()) answer[0] = map.lastKey();
        if(!map.isEmpty()) answer[1] = map.firstKey();
 
        return answer;
    }
}