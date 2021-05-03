import java.util.*;

public class Queen {
    public static void main(String[] args){
        int n  = 8;
        List<char[][]> res = getQueen(n);
        for(char[][] board : res){
            printBoard(board);
            System.out.println();
        }
        System.out.println(res.size());
    }

    private static void printBoard(char[][] board){
        int n = board.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }         
    }

    private static char[][] copyBoard(char[][] board){
        int n = board.length;
        char[][] newBoard = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                newBoard[i][j] = board[i][j];
            }
        }

        return newBoard;         
    }

    public static List<char[][]> getQueen(int n){
        List<char[][]> res = new ArrayList<char[][]>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
            board[i][j] = '.';
            }
        } 

        backTrack(res, board, 0);
        return res;
    }

    private static void backTrack(List<char[][]> res, char[][] board, int row){
        int n = board.length;
        if (row == n){
            res.add(copyBoard(board));
            return;
        }

        for(int col = 0; col < n; col++){
            if(!isValid(board, row, col)){
                continue;
            }

            board[row][col] = 'Q';
            backTrack(res, board, row + 1);
            board[row][col] = '.';
        }


    }
    
    private static boolean isValid(char[][] board, int row, int col){
        int n = board.length;
        for(int i = 0; i < n; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        for(int i = row -1, j = col + 1; i >=0 && j < n; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        for(int i = row - 1, j = col - 1; i >=0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }
}
