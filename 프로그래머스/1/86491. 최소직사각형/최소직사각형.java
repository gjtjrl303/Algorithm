import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int xMax = 0;
        int yMax = 0;
        
        for(int i = 0 ; i < sizes.length; i ++){
            int tempX1 = sizes[i][0];
            int tempY1 = sizes[i][1];
            
            int tempX2 = sizes[i][1];
            int tempY2 = sizes[i][0];
            
            int tempMax1 = Math.max(tempX1, xMax) * Math.max(tempY1, yMax);
            int tempMax2 = Math.max(tempX2, xMax) * Math.max(tempY2, yMax);
            
            if(tempMax1 < tempMax2){
                xMax = Math.max(tempX1, xMax);
                yMax = Math.max(tempY1, yMax);
                answer = Math.max(answer, xMax * yMax);
            }else{
                xMax = Math.max(tempX2, xMax);
                yMax = Math.max(tempY2, yMax);
                answer = Math.max(answer, xMax * yMax);
            }    
        }
        
        System.out.println(answer);
        return answer;
    }
}
