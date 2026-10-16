import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(
        (a,b) -> b - a);
        for(int i = 0 ; i < works.length ; i++){
            queue.add(works[i]);
        }
        
        for(int i = 0 ; i < n ; i++) {
            int biggest = queue.poll();
            if(biggest == 0) break;
            queue.add(biggest - 1);
        }
        
        long answer = 0;
        
        while(!queue.isEmpty()) {
            int number = queue.poll();
            answer += number * number;
        }
    
        return answer;
    }
}