package Google.Easy;

public class TicTacToeWinner {
    
    public String tictactoe(int[][] moves) {

        int n = 3;

        int[] rows = new int[n], cols = new int[n];
        int diag = 0, anti_diag = 0;
        
        int player = 1;
        
        for (int[] move : moves){

            int row = move[0], col = move[1];
            
            rows[row] += player;
            cols[col] += player;
            
            if (row == col){
                diag += player;
            }
            if (row + col == n - 1){
                anti_diag += player;
            }
            
            if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || 
                Math.abs(diag) == n || Math.abs(anti_diag) == n){
                return player == 1 ? "A" : "B";
            }
            
            player *= -1;
        }
       
        return moves.length == n * n ? "Draw" : "Pending";
    }
}
