class Solution {
    
    static int count = 0;
    
    public int solution(int[] numbers, int target) {
        int index = 0;
        dfs(index+1, numbers[index], numbers, target);
        dfs(index+1, -numbers[index], numbers, target);
        
        return count;
    }
    
    private void dfs(int nextIndex, int sum, int[] numbers, int target){
        if(nextIndex == numbers.length) {
            if(sum == target) {
                count++;
            }
            return;
        }
    
        dfs(nextIndex+1, sum + numbers[nextIndex], numbers, target);
        dfs(nextIndex+1, sum - numbers[nextIndex], numbers, target);
    }
}