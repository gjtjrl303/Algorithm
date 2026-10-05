import java.util.*;

class Solution {
    
    static int length;
    static int count = 0;
    static boolean[] isVisited;
    static boolean flag = false;
     
    public int solution(String begin, String target, String[] words) {
        length = begin.length();
        isVisited = new boolean[words.length];
        bfs(begin, target, words);
        
        if(flag) return count;
        return 0;
    }
    
    public void bfs(String begin, String target, String[] words) {
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        int currentSize = 1;
        int nextSize= 0;
        
        while(!queue.isEmpty()){
            String currentString = queue.remove();
            if(currentString.equals(target)) {
                flag = true;    
                break;
            }
            
            for(int i = 0 ; i < words.length ; i++){
                if(isVisited[i]) continue;
                int differentCount = 0;
                for(int j = 0 ; j < length ; j++) {
                    if(currentString.charAt(j) != words[i].charAt(j)) differentCount++; 
                }
                if(differentCount == 1){
                    queue.add(words[i]);
                    isVisited[i] = true;
                    nextSize++;
                }
            }
            
            currentSize--;
            if(currentSize == 0){
                count++;
                currentSize = nextSize;
                nextSize = 0;
            }
        }
    }
}