package SDESheet.RecursionAndBacktracking;

import java.util.HashSet;

public class NQueen {

    public static int totalNQueens(int n) {
        HashSet<Integer> col = new HashSet<>();
        HashSet<Integer> diagonals = new HashSet<>();
        HashSet<Integer> antiDiagonals = new HashSet<>();
        return solveNQueens(n, 0, col, diagonals, antiDiagonals);
    }
    
    public static int solveNQueens(int n, int row, HashSet<Integer> columns, HashSet<Integer> diagonals, HashSet<Integer> antiDiagonals) {
        
        if(row == n)
            return 1;
        
        int count = 0;
        
        for(int col=0; col<n; col++) {
            if(isValidPos(row, col, columns, diagonals, antiDiagonals)) {
                placeQueen(row, col, columns, diagonals, antiDiagonals);
                count += solveNQueens(n, row+1, columns, diagonals, antiDiagonals);
                removeQueens(row, col, columns, diagonals, antiDiagonals);
            }
        }
        return count;
    }
    
    public static boolean isValidPos(int row, int col, HashSet<Integer> columns, HashSet<Integer> diagonals, HashSet<Integer> antiDiagonals) {
        
        if(columns.contains(col) || diagonals.contains(row-col) || antiDiagonals.contains(row+col))
            return false;
        return true;
    }
    
    public static void placeQueen(int row, int col, HashSet<Integer> columns, HashSet<Integer> diagonals, HashSet<Integer> antiDiagonals) {
        
        columns.add(col);
        diagonals.add(row-col);
        antiDiagonals.add(row+col);
    }
    
    public static void removeQueens(int row, int col, HashSet<Integer> columns, HashSet<Integer> diagonals, HashSet<Integer> antiDiagonals) {
        columns.remove(col);
        diagonals.remove(row-col);
        antiDiagonals.remove(row+col);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(totalNQueens(n));
    }
}