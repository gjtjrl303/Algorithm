import java.lang.*;
import java.util.*;

class Solution {
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        
        int sum = 0;
        parent = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }
        
        List<Edge> list = new LinkedList<>();
        
        for(int i = 0 ; i < costs.length ; i++){
            list.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        }
        
        Collections.sort(list);
                
        for(Edge edge : list){
            if(findParent(edge.from, edge.to)) continue;
            unionParent(edge.from, edge.to);
            sum += edge.cost;
        }
        
        return sum;
    }
    
    int getParent(int node){
        if(parent[node] == node) return node;
        return getParent(parent[node]);
    }
    
    void unionParent(int nodeA, int nodeB){
        int parentA = getParent(nodeA);
        int parentB = getParent(nodeB);
        if(parentA < parentB){
            parent[parentB] = parentA;
        }else{
            parent[parentA] = parentB;
        }
    }

    boolean findParent(int nodeA, int nodeB){
        return getParent(nodeA) == getParent(nodeB);
    }
    
    
    class Edge implements Comparable<Edge>{
        int from;
        int to;
        int cost;
        
        public Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge edge){
            return this.cost - edge.cost;
        }
    }
}