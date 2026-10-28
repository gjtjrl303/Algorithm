import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if(n > s) return new int[] {-1};
        
        int numberCount = n;
        int remain = s % n;
        int number = s / n;
        
        int[] numbers = new int[numberCount];
        
        for(int i = numberCount - 1; i >= 0; i--){
            if(remain > 0){
                numbers[i] = number + 1;
                remain--;
            } else{
               numbers[i] = number; 
            } 
        }
        
        return numbers;
    }
}