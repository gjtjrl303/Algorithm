import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int result = 0;

        for(int i = 0; i < n ; i++){
            int stream = 0;
            int number = -1;
            for(int j =0 ; j < n ; j++){
                if(number != grid[i][j]){         
                    stream = 1;
                    number = grid[i][j];
                }else{
                    stream++;
                }
                  if(stream >= m){
                    result++;
                    break;
                }
            }
        }

        for(int i = 0; i < n ; i++){
            int stream = 0;
            int number = -1;
            for(int j =0 ; j < n ; j++){
                if(number != grid[j][i]){
                    stream = 1;
                    number = grid[j][i];
                    }else{
                    stream++;
                }
                 if(stream >= m){
                    result++;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}