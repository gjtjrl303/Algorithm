import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1,o2) -> map.get(o2).compareTo(map.get(o1)));
        
        // for(String key : keySet){
        //     System.out.println(key + ", " + map.get(key));
        // }
        
        for(String key: keySet){
            List<Integer> songIndex = new ArrayList<>();
            
            for(int i = 0 ; i < genres.length; i++){
                if(genres[i].equals(key)){
                    songIndex.add(i);
                }
            }
            
            songIndex.sort((o1,o2) -> {
                if(plays[o1] == plays[o2]) return o1-o2;
                return plays[o2] - plays[o1]; 
            });
            
            for(int i = 0 ; i < Math.min(2, songIndex.size()) ; i++){
                answer.add(songIndex.get(i));
            }
        }
        
        int[] result = new int[answer.size()];
        
        for(int i = 0 ; i < answer.size() ; i++){
            result[i] = answer.get(i);
        }
        
        return result;
    }
}