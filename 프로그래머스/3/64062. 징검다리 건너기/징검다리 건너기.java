import java.util.*;

class Solution {
    
    int left = 0;
    int right = 200_000_000;
    int mid;
    
    public int solution(int[] stones, int k) {
        
        while(left <= right) {
            mid = (left + right) / 2;
        
            if(canSuccess(stones, k, mid)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
            
            System.out.println(left + " " + right + " " + mid);
        
        }
    return right;
    }
    
    public boolean canSuccess(int[] stones, int k, int mid) {
        int count = 0;
        
        for(int i = 0 ; i < stones.length ; i++){
            if(stones[i] >= mid) {
                count = 0;
            }else{
                count++;
                if(count >= k) return false;  
            }
        }
        return true;    
    }  
     
}