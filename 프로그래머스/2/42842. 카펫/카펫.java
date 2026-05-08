import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i = 1 ; i <= yellow ; i++){
            if(yellow % i != 0) continue;
            
            int x = yellow / i;
            int y = i;
            
            if(brown == 4 + 2*x + 2*y){
                answer[0] = x+2;
                answer[1] = y+2;
                return answer;
            }  
        }
        
        return null;
    }
}