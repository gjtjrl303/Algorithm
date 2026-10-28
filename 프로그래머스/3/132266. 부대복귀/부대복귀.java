import java.util.*;

class Solution {
    
    List<Node> graph = new ArrayList<>();
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        int[] answer = new int[sources.length];
        for(int i = 0 ; i < n ; i++){
            graph.add(new Node(i+1));
        }
        
        for(int i = 0 ; i < roads.length ; i++){
            int start = roads[i][0];
            int end = roads[i][1];
            
            Node startNode = graph.get(roads[i][0] - 1);
            Node endNode = graph.get(roads[i][1] - 1);
            startNode.addEdge(endNode);
            endNode.addEdge(startNode);  
        }
        
        for(int i = 0 ; i < sources.length ; i++){
            answer[i] = bfs(sources[i], destination);
        }
        
        return answer;
    }
    
    public int bfs(int start, int destination){
        Node node = graph.get(start-1);
        boolean[] isVisited = new boolean[graph.size() + 1];
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        isVisited[node.getValue()] = true;
        int count = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0 ; i < size ; i++){
                Node currentNode = queue.poll();
                if(currentNode.getValue() == destination){
                    return count;
                } 
                List<Node> edges = currentNode.getEdges();
                for(Node oppositeNode : edges){
                    if(isVisited[oppositeNode.getValue()]) continue;
                    queue.add(oppositeNode);
                    isVisited[oppositeNode.getValue()] = true;
                }
            }
            count++;
        }
        return -1;    
    }
    
    public class Node{
        int value;
        List<Node> edges = new ArrayList<>();
        
        public Node(int value){
            this.value = value;
        }
        
        public void addEdge(Node node){
            edges.add(node);
        }
        
        public List<Node> getEdges(){
            return edges;
        }
        
        public int getValue(){
            return value;
        }
        
        @Override 
        public String toString(){
            return String.valueOf(value);
        }
    }
}