import java.util.Scanner;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int result = 0;

        for(int i = 0 ; i < n - 1; i++){
            for(int j = 0 ; j < m - 1; j++){
                int sum = 0;
                sum += grid[i][j];
                sum += grid[i+1][j];
                sum += grid[i+1][j+1];
                sum += grid[i][j+1];

                result = Math.max(sum - grid[i][j], result);
                result = Math.max(sum - grid[i+1][j], result);
                result = Math.max(sum - grid[i+1][j+1], result);
                result = Math.max(sum - grid[i][j+1], result);
            }
        }

        for(int i = 0 ; i <= n - 3; i++){
            for(int j = 0 ; j < m; j++){
                int sum = 0;
                sum += grid[i][j];
                sum += grid[i+1][j];
                sum += grid[i+2][j];

                result = Math.max(sum, result);
            }
        }

        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j <= m-3; j++){
                int sum = 0;
                sum += grid[i][j];
                sum += grid[i][j+1];
                sum += grid[i][j+2];

                result = Math.max(sum, result);
            }
        }  
        System.out.println(result);
    }
}