import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[] dp = new int[500];
        dp[0] = triangle[0][0];
        
        for(int i = 1 ; i < triangle.length ; i++){
            int[] copy = Arrays.copyOf(dp, i);
            for(int j = 0 ; j <= i ; j++){
                if(j == 0){
                    dp[j] = copy[j] + triangle[i][j];
                }else if( j == i){
                    dp[j] = copy[j - 1] + triangle[i][j];
                }else{
                    dp[j] = Math.max(copy[j - 1], copy[j]) + triangle[i][j];   
                }
            }
        }
        
        int max = 0;
        for(int i = 0 ; i < 500 ; i++){
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}