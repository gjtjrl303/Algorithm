class Solution {
    public int solution(int sticker[]) {
        
        if(sticker.length == 1) return sticker[0];
        if(sticker.length == 2) return Math.max(sticker[0],sticker[1]);
        
        int[][] dp = new int[2][sticker.length];
        dp[0][0] = sticker[0];
        dp[0][1] = Math.max(dp[0][0], sticker[1]);
        dp[1][1] = sticker[1];
        dp[1][2] = Math.max(dp[1][1], sticker[2]);
        
        for(int i = 2 ; i < sticker.length - 1 ; i++){
            dp[0][i] = Math.max(sticker[i] + dp[0][i-2], dp[0][i-1]);
        }
        
        for(int i = 3 ; i < sticker.length ; i++){
            dp[1][i] = Math.max(sticker[i] + dp[1][i-2], dp[1][i-1]);
        }
        
        return Math.max(dp[0][sticker.length - 2], dp[1][sticker.length-1]);
    }
}