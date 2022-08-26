package Topics.Recursion;

public class Sudoku {
    int n = 3;
  // row size
  int N = n * n;

  int [][] rows = new int[N][N + 1];
  int [][] columns = new int[N][N + 1];
  int [][] boxes = new int[N][N + 1];

  char[][] board;

  boolean sudokuSolved = false;
    
  public boolean validNum(int row, int col, int num) {
      int idx = (row/n) * n + col/n;
      return rows[row][num] + columns[col][num] + boxes[idx][num] == 0;
  }
    
  public void placeNum(int row, int col, int num) {
      int idx = (row/n) * n + col/n;
      
      rows[row][num]++;
      columns[col][num]++;
      boxes[idx][num]++;
      board[row][col] = (char)(num + '0');
  }
    
  public void placeNextNum(int row, int col) {
      if(row+1 == N && col+1 == N)
          sudokuSolved = true;
      
      else if(col+1 == N)
          backtrack(row+1, 0);
      
      else
          backtrack(row, col+1);
  }
    
  public void removeNum(int row, int col, int num) {
      int idx = (row/n) * n + col/n;
      
      rows[row][num]--;
      columns[col][num]--;
      boxes[idx][num]--;
      board[row][col] = '.';
  }

  public void backtrack(int row, int col) {
      
      if(board[row][col] == '.') {
          for(int i=1; i<10; i++) {
              if(validNum(row, col, i)) {
                  placeNum(row, col, i);
                  placeNextNum(row, col);
                  if(!sudokuSolved) removeNum(row, col, i);
              }
          }
      }
      else placeNextNum(row, col);  
  }

  public void solveSudoku(char[][] board) {
    this.board = board;

    // init rows, columns and boxes
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        char num = board[i][j];
        if (num != '.') {
          int d = Character.getNumericValue(num);
          placeNum(i, j, d);
        }
      }
    }
    backtrack(0, 0);
  }

  public static void main(String[] args) {
    String[][] board = {{"5","3",".",".","7",".",".",".","."},{"6",".",".","1","9","5",".",".","."},{".","9","8",".",".",".",".","6","."},{"8",".",".",".","6",".",".",".","3"},{"4",".",".","8",".","3",".",".","1"},{"7",".",".",".","2",".",".",".","6"},{".","6",".",".",".",".","2","8","."},{".",".",".","4","1","9",".",".","5"},{".",".",".",".","8",".",".","7","9"}};
  }
}
