import java.util.*;

class Solution {
    
    boolean[][] graph;
    int min = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        graph = new boolean[n+1][n+1];
     
        
        for(int i = 0 ; i < wires.length ; i++){
            graph[wires[i][0]][wires[i][1]] = true;
            graph[wires[i][1]][wires[i][0]] = true;
        }
          
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                boolean[] visited = new boolean[n+1];
                if(graph[i][j]){
                    graph[i][j] = false;
                    graph[j][i] = false;
                    
                    int size = calculateSize(i, n, visited);
                    min = Math.min(min, Math.abs(size - (n - size)));
                    
                    graph[i][j] = true;
                    graph[j][i] = true;
                }
            }
        }
        
        return min;
    }
    
    public int calculateSize(int currentNode, int nodeCount , boolean[] visited){
        
        int size = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(currentNode);
        visited[currentNode] = true;
        
        while(!queue.isEmpty()){
            int targetNode = queue.poll();
            
            for(int i = 1 ; i <= nodeCount ; i++){
                if(!visited[i] && graph[targetNode][i]) {
                    queue.offer(i);
                    visited[i] = true;
                    size++;
                }
            }
        }
        
        return size;
    }
    
    
    public void printGraph(){
         for(int i = 1 ; i < graph.length ; i++){
            for(int j = 1 ; j < graph.length ; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}