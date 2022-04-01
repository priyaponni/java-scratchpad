import java.util.HashSet;
import java.util.Set;

public class makeZeroes {
    public void setZeroes(int[][] matrix) {

        for(int i=0; i< matrix.length; i++) {
            for(int j=0; j <matrix[i].length; j++){
                if (matrix[i][j] == 0) {
                    // make the row as 2
                    for(int k = 0; k < matrix[i].length; k++ ){
                        if(matrix[i][k] != 0)
                            matrix[i][k] = -1;
                    }
                    for(int k = 0; k < matrix.length; k++ ){
                        if(matrix[k][i] != 0)
                            matrix[k][j] = -1;
                    }
                }
            }
        }
        for(int i=0; i< matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
        }

        for(int i=0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0}, {3,4,5,2},{1,3,1,5}};
        makeZeroes soln = new makeZeroes();
        soln.setZeroes(matrix);
        System.out.println();
        for(int i=0; i< matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
        }


    }
}
