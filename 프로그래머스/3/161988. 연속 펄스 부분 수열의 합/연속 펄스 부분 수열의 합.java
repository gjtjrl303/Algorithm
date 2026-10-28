import java.util.*;

class Solution {
    long max = Long.MIN_VALUE;
    int[][] array;
    
    public long solution(int[] sequence) {
        
        array = new int[2][sequence.length];
        
        for(int i = 0, j = 1 ; i < sequence.length ; i++){   
            array[0][i] = sequence[i] * j;
            j *= -1;
            array[1][i] = sequence[i] * j; 
         }
        
        for(int i = 0; i < 2; i++){
            dp(array[i]);
        }
        
        return max;
    }
    
    public void dp(int[] array) {
        
        long tempMax = Long.MIN_VALUE;
        long[] dp = new long[array.length];
        dp[0] = array[0];
        max = Math.max(max, dp[0]);
        
        for(int i = 1 ; i < array.length ; i++){
            dp[i] = Math.max(dp[i-1] + array[i], array[i]);
            tempMax = Math.max(tempMax, dp[i]);
        }
        
        // for(int i = 0 ; i < dp.length ; i++){
        //     System.out.print(dp[i] + " ");
        // }
        max = Math.max(max, tempMax);
        // System.out.println(max);
    }
}
