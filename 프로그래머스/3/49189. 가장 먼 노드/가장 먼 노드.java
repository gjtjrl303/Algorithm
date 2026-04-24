import java.util.*;


class Solution {
    
    public int solution(int n, int[][] edge) {
        
        int answer = 0;  
        
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n+1];
        
        visited[0] = true;
        
        Deque<Integer> queue = new ArrayDeque<>();
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i <= n ; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < edge.length; i++){
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        
        List<Integer> nodes = graph.get(1);
        visited[1] = true;
        for(int i = 0 ; i< nodes.size(); i++){
            queue.push(nodes.get(i));
            visited[nodes.get(i)] = true;
            answer++;
        }
        
        while(!queue.isEmpty()){
            answer = 0;
            int size = queue.size();
             
            for(int j = 0; j < size ; j++){
                int node = queue.pollFirst();
                List<Integer> targetNodes = graph.get(node);
            
                for(int i = 0; i < targetNodes.size() ; i++){
                    if(!visited[targetNodes.get(i)]){
                        queue.add(targetNodes.get(i));
                        visited[targetNodes.get(i)] = true;
                        answer++;
                    }
                }
            }
            
            stack.push(answer);
        }
        stack.pop();
        return stack.pop();    
    }
}