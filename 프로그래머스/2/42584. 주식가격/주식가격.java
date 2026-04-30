class Solution {
    public int[] solution(int[] prices) {
        
        int[] answer = new int[prices.length];
        int index = 0;
        
        for(int i = 0 ; i < prices.length ; i++){
            int count = 0;
            for(int j = i + 1 ; j < prices.length ; j++){
                count++;
                if(prices[i] > prices[j]) break;
            }
            answer[index++] = count;
        }
        
        return answer;
    }
 
}