import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int boatCount = 0;
        
        while(left <= right){
            if(people[left] + people[right] <= limit){
                right--;
                left++;
            }else{
                right--;
            }
            boatCount++;
        }
        
        return boatCount;
    }
}