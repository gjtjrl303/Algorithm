import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long max = (long) n * times[times.length-1];
        long mid = max/2;
        long min = 0;
        long temp = mid;
                
        while(min <= max){
            long sum = 0;
            
            for(int i = 0 ; i < times.length; i++){
                sum += mid/times[i];
            }
            
            if(sum >= n)max = mid - 1;
            else min = mid + 1;
            
            mid = (max+min)/2;
        }
        
        
        return min;
    }
}