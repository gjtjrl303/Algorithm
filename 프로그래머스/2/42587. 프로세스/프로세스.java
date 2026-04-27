import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        int count = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        
        for(int i = 0 ; i < priorities.length ; i++){
            queue.addLast(priorities[i]);            
        }
        
//         int size = queue.size();
//          for(int i = 0 ; i < size ; i++){
//             System.out.println(queue.removeFirst());         
//         }
        
        while(true){
            int target = queue.removeFirst();
            boolean flag = false;
    
            // for(int value : queue){
            //     System.out.print(value);
            // }
            // System.out.println();
            
            for(int i = 9 ; i > target ; i--){
                if(queue.contains(i)){
                    if(location == 0){
                        location = queue.size();
                        queue.addLast(target);
                        flag = true;
                        break;
                    }else{
                        location--;
                        queue.addLast(target);
                        flag = true;
                        break;
                    }
                }
            }
            if(flag) continue;
            
            if(location == 0){
                count++;
                return count;
            }else{
                location--;
                count++;
             }
    
        }
    }
}