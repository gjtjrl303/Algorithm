class Solution {
    public int solution(int n, int[] stations, int w) {
        int size = 2 * w + 1;
        int tempStart = 1;
        int tempEnd = 1;
        int count = 0;
        
        for(int i = 0 ; i < stations.length ; i++){
            int tempStation = stations[i];
            int tempNextStart = Math.min(tempStation + w + 1, n + 1);
            tempEnd = Math.max(tempStation - w, 1);
            
            int tempSize = tempEnd - tempStart;
            tempStart = tempNextStart; 
            if(tempSize < 0) continue;
            
            int remain = tempSize % size;
            count += tempSize / size;
            if(remain != 0) count++;
            
            if(tempStart > n) break;
        }
        
        if(n > tempStart) {
            int tempSize = n + 1 - tempStart;
            
            int remain = tempSize % size;
            count += tempSize / size;
            if(remain != 0) count++;
        }else if(n == tempStart){
            count++;
        }
        
        return count;
    }
}