import java.util.*;

class Solution {
    
    boolean[] isVisited;
    
    
    public int solution(int n, int[][] computers) {
        isVisited = new boolean[n];
        return bfs(n, computers);
    }
    
    public int bfs(int vertexCount, int[][]computers){
        int networkCount = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0 ; i < vertexCount ; i++){
            if(!isVisited[i]){
                queue.offer(i);
                isVisited[i] = true;
            }else{
                continue;
            }
            
            while(!queue.isEmpty()){
                int vertex = queue.poll();
                
                for(int j = 0 ; j < vertexCount ; j++){
                    if(computers[vertex][j] == 1 && !isVisited[j]){
                        queue.offer(j);
                        isVisited[j] = true;
                    }
                }
            }
            
            // for(int k = 0 ; k < isVisited.length ; k++){
            //     System.out.print(isVisited[k] + " ");
            // }
            // System.out.println();
            networkCount++;
        }        
        
        return networkCount == 0 ? 1 : networkCount;
    }
}