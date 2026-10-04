import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        long[][] matrix = new long[n][m];
        boolean isZero = false; 
        
        for(int i = 0 ; i < puddles.length ; i++){
            int x = puddles[i][0] - 1;
            int y = puddles[i][1] - 1;
            matrix [y][x] = -1;
        }
        
        for(int i = 0 ; i < m ; i++){
            if(matrix[0][i] == -1) isZero = true;
            if(isZero) matrix[0][i] = 0;
            else matrix[0][i] = 1;
        }
        
        isZero = false; 
        for(int i = 0 ; i < n ; i++){
            if(matrix[i][0] == -1) isZero = true;
            if(isZero) matrix[i][0] = 0;
            else matrix[i][0] = 1;
        }
        
        // for(int i = 0 ; i < n ; i ++){
        //     for(int j = 0 ; j < m ; j++){
        //         System.out.print(matrix[i][j]);
        //     }
        //     System.out.println();
        // }
        
        for(int i = 1 ; i < n ; i++){
            for(int j = 1 ; j < m ; j++){
                if(matrix[i][j] == -1) continue;
                if(matrix[i-1][j] == -1 && matrix[i][j-1] == -1){
                    matrix[i][j] = 0;
                }
                else if(matrix[i-1][j] == -1){
                    matrix[i][j] = matrix[i][j-1];
                }
                else if(matrix[i][j-1] == -1){
                    matrix[i][j] = matrix[i-1][j];
                }
                else matrix[i][j] = ((matrix[i-1][j] + matrix[i][j-1]) % 1_000_000_007L);
            }
        }
        
        // for(int i = 0 ; i < n ; i ++){
        //     for(int j = 0 ; j < m ; j++){
        //         System.out.print(matrix[i][j]);
        //     }
        //     System.out.println();
        // }
        
        return (int)(matrix[n-1][m-1] % 1_000_000_007L);
    }
}