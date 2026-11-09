import java.util.Scanner;
import java.util.*;

public class Main {
    static int[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                grid[i][j] = sc.nextInt();
                // if(grid[i][j] == 1) count++;
            }
        }
        
        matrix = grid;
        int maxCount = 0;
        // int maxPrice = count * m;

        for(int i = 0 ; i < n ; i++){
            for(int  j = 0 ; j < n ; j++){
                for(int k = 0 ; k <= 40 ; k++){
                    int count = calculateCount(n, i, j, k);
                    if(k*k + (k+1)*(k+1) <= m*count){
                        // if(count == 4){
                        //     System.out.println(k + "" + " y = " + i + " x = " +  j);
                        // }
                        maxCount = Math.max(maxCount, count);
                    }
                }
            } 
        }
        System.out.println(maxCount);
    }

    public static int calculateCount(int n, int currentX, int currentY, int width){
        int count = 0;
        for(int i = -width; i <= width ; i++){
            int diff = Math.abs(width - Math.abs(i));
            for(int j = -diff ; j <= diff ; j++){
                if(!(0 <= currentX + j && currentX + j < n  && 0 <= currentY + i && currentY +i < n)) continue;
                if(matrix[i + currentY][j + currentX]==1) count++;
            }
        }
        return count;
    }
}