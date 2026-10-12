import java.util.*;

class Solution {
    int[][] dags;
    List<List<Integer>> win;
    List<List<Integer>> lose;
    
    public int solution(int n, int[][] results) {
        dags = new int[n+1][2];
        
        win = new LinkedList<>();
        for(int i = 0 ; i <= n ; i++){
            win.add(new LinkedList<>());
        }
        lose = new LinkedList<>();
        for(int i = 0 ; i <= n ; i++){
            lose.add(new LinkedList<>());
        }
        
        for(int i = 0 ; i < results.length ; i++){
            int winner = results[i][0];
            int loser = results[i][1];
            win.get(winner).add(loser);
            lose.get(loser).add(winner);
        }
        
        System.out.println(win);
        System.out.println(lose);
        
        for(int i = 1 ; i <= n ; i++){
            boolean[] visited = new boolean[n+1];
            visited[i] = true;
            dags[i][0] = dfs(win, i, visited);
        }
        
        for(int i = 1 ; i <= n ; i++){
            boolean[] visited = new boolean[n+1];
            visited[i] = true;
            dags[i][1] = dfs(lose, i, visited);
        }
        
        // for(int i = 0 ; i <= n ; i++){
        //     System.out.print(dags[i][0]);
        //     System.out.println(" " + dags[i][1]);
        // }
        
        int count = 0;
        for(int i = 0 ; i <= n ; i++){
            if(dags[i][0] + dags[i][1] == n - 1) count++;
        }
        
        return count;
    }
    
    public int dfs(List<List<Integer>> lists, int n, boolean[] visited) {
        int count = 0;
        List<Integer> list = lists.get(n);
        for(Integer player : list){
            if(!visited[player]){
                visited[player] = true;
                count += dfs(lists, player, visited) + 1;
            }
        }
        return count;
    }
}