import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class Solution {

    public int rows;
    public int columns;
    public int[][] grid;

    public Solution(int rows, int columns){
        this.rows=rows;
        this.columns=columns;
        grid = new int[rows][columns];
    }

    public void initialize(){
        for(int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                if(Math.random() < 0.5) {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = 1;
                }
            }
        }
    }

    public void printMatrix(){
        for (int i=0;i<this.rows;i++){
            for(int j=0;j<this.columns;j++){
                System.out.print(grid[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public void game(){
        for (int i=0;i<this.rows;i++){
            for(int j=0;j<this.columns;j++){
                int cell = grid[i][j];
                if(cell == 0){
                    System.out.println("Neighbours of dead "+i+" , "+j+": "+neighbours(i,j));
                    int[] result = neighbours(i,j);
                    int ones=0;
                    int zeros=0;
                    for(int k=0;i<result.length;i++){

                    }


                } else {
                    int[] result = neighbours(i,j);
                    for (int k=0;k<result.length;i++){

                    }
                }
            }
        }
    }

    public int[] neighbours(int col, int row){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int colNum = col - 1 ; colNum <= (col + 1) ; colNum +=1  ) {
            for (int rowNum = row - 1 ; rowNum <= (row + 1) ; rowNum +=1  ) {
                //if not the center cell
                if(! ((colNum == col) && (rowNum == row))) {
                    //make sure it is within  grid
                    if(withinGrid (colNum, rowNum)) {
                        list.add(grid[rowNum][colNum]);
                    }
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }



    public boolean withinGrid(int colNum, int rowNum) {

        if((colNum < 0) || (rowNum <0) ) {
            return false;    //false if row or col are negative
        }
        if((colNum >= this.columns) || (rowNum >= this.rows)) {
            return false;    //false if row or col are > 75
        }
        return true;
    }



    public static void main(String[] args){
        Solution s = new Solution(3,3);
        s.initialize();
        s.printMatrix();
        s.game();
        //s.printMatrix();
    }



}
