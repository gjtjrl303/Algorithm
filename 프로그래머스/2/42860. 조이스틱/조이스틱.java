import java.util.*;
import java.lang.*;

class Solution {
    
    public int solution(String name) {
        int count = 0;
        int move = name.length() - 1;
        int length = name.length();
        
        char[] charList = name.toCharArray();
       
        for(int i = 0 ; i < charList.length ; i++){
            
            if(charList[i] < 'N') count += charList[i] - 'A';
            else count += 26 - (charList[i] - 'A');
            
            int next = i + 1;
            
            while(next < charList.length && charList[next] == 'A'){
                next++;
            }
            
            move = Math.min(move, i * 2 +  length - next);
            move = Math.min(move, 2*(length-next) + i);
        }
        
        return count + move;
    }
}