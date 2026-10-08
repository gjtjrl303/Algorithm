import java.util.*;

class Solution {
    
    int[][] matrix = new int[102][102];
    boolean[][] isVisited = new boolean[102][102];
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] newRectangle = new int[rectangle.length][4];
        for (int i = 0 ; i < rectangle.length ; i++){
            newRectangle[i][0] = rectangle[i][0]*2;
            newRectangle[i][1] = rectangle[i][1]*2;
            newRectangle[i][2] = rectangle[i][2]*2;
            newRectangle[i][3] = rectangle[i][3]*2;
        }
        
        rectangle = newRectangle;
        
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        for (int i = 0 ; i < rectangle.length ; i++){
            scratch(rectangle[i]);
        }
        
        for(int i = 0 ; i < rectangle.length ; i++){
            int x = Math.min(rectangle[i][0],rectangle[i][2]);
            int y = Math.min(rectangle[i][1], rectangle[i][3]);
            int anotherX = Math.max(rectangle[i][0], rectangle[i][2]);
            int anotherY = Math.max(rectangle[i][1], rectangle[i][3]);
        
            for(int j = y + 1 ; j < anotherY ; j++){
                for(int k = x + 1 ; k < anotherX ; k++){
                    matrix[k][j] = 0;
                }
            }
        }
        
        for(int i = 0 ; i < 20 ; i++){
            for(int j = 0 ; j < 20 ; j++){
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
        
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(characterX, characterY));
        isVisited[characterX][characterY] = true;
        
        int count = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                Point point = queue.remove();
                if(point.x == itemX && point.y == itemY) return count / 2 ;
                if(point.up()) {
                    queue.add(new Point(point.x, point.y-1));
                    isVisited[point.x][point.y-1] = true;
                }
                if(point.down()) {
                    queue.add(new Point(point.x, point.y+1));
                    isVisited[point.x][point.y+1] = true;
                };
                if(point.right()) {
                    queue.add(new Point(point.x+1, point.y));
                    isVisited[point.x+1][point.y] = true;
                };
                if(point.left()) {
                    queue.add(new Point(point.x-1, point.y));
                    isVisited[point.x-1][point.y] = true;
                };
            }
            count++;
        }
        return 0;
    }
    
    private void scratch(int[] rectangle){
        int x = Math.min(rectangle[0],rectangle[2]);
        int y = Math.min(rectangle[1], rectangle[3]);
        int anotherX = Math.max(rectangle[0], rectangle[2]);
        int anotherY = Math.max(rectangle[1], rectangle[3]);
        
        for(int i = x ; i <= anotherX ; i++){
            matrix[i][y] = 1;
            matrix[i][anotherY] = 1; 
        }
        
        for(int i = y ; i <= anotherY ; i++){
            matrix[x][i] = 1;
            matrix[anotherX][i] = 1; 
        }
    }
    
    class Point {
        int x;
        int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }    
        
        public boolean up() {
            return (matrix[x][y-1] == 1) && !isVisited[x][y-1];
        }
        
        public boolean down() {
            return (matrix[x][y+1] == 1)&& !isVisited[x][y+1];
        }
        
        public boolean right() {
            return (matrix[x+1][y] == 1)&& !isVisited[x+1][y];
            
        }
        
        public boolean left() {
            return (matrix[x-1][y] == 1)&& !isVisited[x-1][y];
        }
    }
}