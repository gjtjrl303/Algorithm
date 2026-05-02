import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int size = citations.length;
        
        for(int i = citations[citations.length-1] ; i >=0 ; i--){
            int up=0;
            for(int j = 0 ; j < citations.length ; j++){
                if(i <= citations[j]) up++;
            }
            // System.out.println(up + ", " + (size - up));
            if(i <= up && size - up <= i) return i;
        }
        
        return citations.length;
    }
}