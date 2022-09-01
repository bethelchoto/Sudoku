public class SudokuSolver {
    private static final int GRID_SIZE = 9;

    public static void main (String [] args){
        int [][] board = {
            {0, 0, 0, 0, 3, 0, 0, 0, 0},
            {0, 0, 5, 0, 0, 0, 6, 0, 2},
            {0, 8, 0, 4, 0, 0, 7, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 3, 0, 0, 0, 0, 0, 4, 0},
            {0, 0, 6, 0, 1, 2, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 3, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 2, 0, 0, 5, 0, 0, 8}

        };
        System.out.println("-----Original Board-------");
            printBoard(board);

        if(BoardSolver(board)){
            System.out.println("-----Soduku Solved Completly-----");
        }
            else 
        {
            System.out.println("*********Unslovable board!!!**********");
        }
         printBoard(board);
    }

    private static void printBoard(int [][] board){
        for(int row = 0; row < GRID_SIZE; row++){
            if (row % 3 == 0 && row != 0 ){
                System.out.println("-----------");
            } 
            for(int column = 0; column < GRID_SIZE; column++){
                if (column % 3 == 0 && column != 0){
                    System.out.print("|");
                }
               
                System.out.print(board[row][column]);
            }
            System.out.println();
        }
    }
    private static boolean isNumberInRow(int [][] board, int number, int row){
        for(int i = 0; i < GRID_SIZE; i++){
            if(board[row][i] ==  number){
                return true;
            }
        }
        return false;
    }
    private static boolean isNumberInColumn(int [][] board, int number, int column){
        for (int i = 0; i < GRID_SIZE; i++){
            if(board[i][column] == number){
                return true;
            }
        }
        return false;
    }
    private static boolean isNumberInBox(int [][] board, int number, int row, int column){
        int isInRowBox = row - row % 3;
        int isInColumnBox = column - column % 3;
        for(int i = isInRowBox; i < isInRowBox + 3; i++){
            for(int j = isInColumnBox; j<isInColumnBox + 3; j ++){
                if(board[i][j] == number){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean isAValidPlacement(int [][] board,  int number, int row, int column){
        return !isNumberInColumn(board, number, column) &&
                !isNumberInBox(board, number, row, column) &&
                !isNumberInRow(board, number, row);

    }
    private static boolean BoardSolver(int [][] board){
        for(int row = 0; row < GRID_SIZE; row++){
            for(int column = 0; column < GRID_SIZE; column++){
                if(board[row][column] ==  0){
                   for(int TryNumber = 1; TryNumber <= GRID_SIZE; TryNumber++){
                       if(isAValidPlacement(board , TryNumber, row, column)){
                        board[row][column] = TryNumber;
                        
                        if (BoardSolver(board)){
                            return true;
                        }
                        else 
                        {
                         board[row][column] = 0;
                        }
                       }
                    } 
                    return false; 
                }    
            }
        }
        return true; 
    }
} 