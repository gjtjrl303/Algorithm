import java.util.*;

class Solution {
    public int solution(int distance, int[] rock, int n) {
        int left = 1;
        int right = distance;
        int[] rocks = new int[rock.length + 2];
        rocks[0] = 0;
        rocks[rock.length + 1] = distance;
        for(int i = 0 ; i < rock.length ; i++){
            rocks[i+1] = rock[i];
        }
        
        Arrays.sort(rocks);
        
        while(left <= right) { 
            int mid = (left + right) / 2;
            int count = 0;
            int current = 0;
            for(int i = 1 ; i < rocks.length ; i++){
                if(mid <= rocks[i] - current) {
                    current = rocks[i];
                    // System.out.println(current + " " + count);
                }else {
                    while(mid > rocks[i] - current){
                        count++;
                        i++;
                        if(i >= rocks.length) break;
                        // System.out.println(current + " " + count);
                    }
                    if( i >= rocks.length) break;
                    current = rocks[i];
                    // System.out.println(current + " " + count);
                }
            }
            
            if(count <= n) {
                left = mid + 1;
                // System.out.println(mid);               
            }
            else right = mid - 1;
        }
        
        return right;
        
    }
}