import java.lang.*;
import java.util.*;

class Solution {
    
    int[] goX = {0, 1, 0, -1};
    int[] goY = {-1, 0, 1, 0};
    boolean[][] isVisited;
    int[][] map;
    int n, m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        map = maps;
        isVisited = new boolean[n][m];
        map = maps;
        
        return bfs();
    }
    
    public int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1));
        isVisited[0][0] = true;
        
        while(!queue.isEmpty()){
            Point now = queue.remove();
            if(now.x == n - 1 && now.y == m - 1) {
                return now.distance;
            }
               
            for(int i = 0; i < 4; i++){
                if(canGo(now.x + goX[i], now.y + goY[i])){
                 
                    queue.add(new Point(now.x + goX[i], now.y + goY[i], now.distance + 1));
                    isVisited[now.x + goX[i]][now.y + goY[i]] = true;
                   
                }
            }    
        }
        
        return -1;
    }
    
    private boolean canGo(int x, int y){
        if(x < 0 || x >= n) return false;
        if(y < 0 || y >= m) return false;
        if(isVisited[x][y] || map[x][y] == 0) return false;
        return true;
    }
    
    static class Point {
        public int x;
        public int y;
        public int distance;
        
        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}