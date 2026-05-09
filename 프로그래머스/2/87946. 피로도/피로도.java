import java.util.*;

class Solution {
    
    static int max = 0;
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        
        for(int i = 0 ; i < dungeons.length ; i++){
            if(visited[i]) continue;
            
            visited[i] = true;
            if(k >= dungeons[i][0]) {
                dfs(k - dungeons[i][1], dungeons, 1);
            }
            else{
               dfs(k, dungeons, 0); 
            } 
            visited[i] = false;
        }
        
        return max;
    }
    
    static void dfs(int k, int[][] dungeons, int count){
        
        int temp = 0;
        for(int i = 0 ; i < visited.length ; i++){
            if(visited[i]) temp++;
        }       
        
        if(temp == visited.length){
            max = Math.max(max, count);
            return;
        }
        
        for(int i = 0 ; i < dungeons.length ; i++){
            if(visited[i]) continue;
            
            visited[i] = true;
            
            if(k >= dungeons[i][0]){
                dfs(k - dungeons[i][1], dungeons, count + 1);
            } 
            else {
                dfs(k, dungeons, count);
            }
            visited[i] = false;
        }
    }
}