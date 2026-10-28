import java.util.*;

class Solution {
   
    LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
    int minSize = Integer.MAX_VALUE;
    int count;
    
    int answerStart;
    int answerEnd;
    
    public int[] solution(String[] gems) {
        
        HashSet<String> set = new HashSet<>();
        for(String str : gems){
            set.add(str);
        }
        
        count = set.size();
        
        for(int i = 0 ; i < gems.length ; i++){
            String string = gems[i];
            if(map.containsKey(string)){
                map.remove(string);
            }
            map.put(string, i);

            if(map.size() == count){                                
                int end = map.lastEntry().getValue();
                int start = map.firstEntry().getValue();
                
                if(end - start < minSize){
                    minSize = end - start;
                    answerStart = start + 1;
                    answerEnd = end + 1;
                }   
            }
        }
            
        return new int[]{answerStart, answerEnd};
    }
}