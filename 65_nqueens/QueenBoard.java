/*
Flying Spanish Actors: Faiyaz Rafee, Alif Rahman
APCS
HW 65 -- How Many Queens Can a Thinker Place, If a Thinker Can Place Queens -- Make a solution
2022-02-16

DISCO PARTYYYYY:
- we need iteration to help us.
- shoutout to lichess.

QCC:
- how can you do this without loops?
- what is the point of solve()?

 class QueenBoard
 Generatees solutions for N-Queens problem.
 USAGE:
 1. Peruse. Transcribe your KtS verbiage into block comments preceding each
 method where necessary.
 2. Implement solver method.
 */

public class QueenBoard {

  private int[][] _board;

  public QueenBoard(int size) {
    _board = new int[size][size];
  }

  /***
   * precondition: board is filled with 0's only.
   * postcondition:
   * If a solution is found, board shows position of N queens,
   * returns true.
   * If no solution, board is filled with 0's,
   * returns false.
   */
  public boolean solve() {
    return solveH(0);
  }

  /**
   * Helper method for solve.
   */
  private boolean solveH(int col) {
    // returns true if algo completes meaning all queens on board
    if (col == _board.length) {
      return true;
    }
    // check for each row
    for (int i = 0; i < _board.length; i++) {
      // check if spot is availiable
      if (_board[i][col] == 0) {
        // adds the queen
        addQueen(i, col);
        // solves next column
        if (solveH(col + 1)) {
          return true;
        }
        // if solve doesnt work, remove the queen
        removeQueen(i, col);
      }
    }
    // there are no solutions
    return false;
  }

  public void printSolution() {
    /**
     * Print board, a la toString...
     * Except:
     * all negs and 0's replaced with underscore
     * all 1's replaced with 'Q'
     */
    String ans = "";
    for (int r = 0; r < _board.length; r++) {
      for (int c = 0; c < _board[0].length; c++) {
        if ((_board[r][c] == 0) || (_board[r][c] < 0)) {
          ans += "_" + "\t";
        } else {
          ans += "Q" + "\t";
        }
      }
      ans += "\n";
    }
    System.out.println(ans);
  }

  // ================= YE OLDE SEPARATOR =================

  /***
   * Adds queen to the board at _board[row][col] if position is valid
   * precondition: that row and col are within range
   * postcondition: returns false or queen is placed, and the areas it can attack
   * are subtracted by 1 and returns true
   */
  private boolean addQueen(int row, int col) {
    if (_board[row][col] != 0) {
      return false;
    }
    _board[row][col] = 1;
    int offset = 1;
    while (col + offset < _board[row].length) {
      _board[row][col + offset]--;
      if (row - offset >= 0) {
        _board[row - offset][col + offset]--;
      }
      if (row + offset < _board.length) {
        _board[row + offset][col + offset]--;
      }
      offset++;
    }
    return true;
  }

  /***
   * Removes queen at _board[row][col] if there is one ther
   * precondition: that row and col are within range
   * postcondition: returns false or queen is removed, and the areas it previously
   * could attack are added to by 1 and returns true
   */
  private boolean removeQueen(int row, int col) {
    if (_board[row][col] != 1) {
      return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while (col + offset < _board[row].length) {
      _board[row][col + offset]++;
      if (row - offset >= 0) {
        _board[row - offset][col + offset]++;
      }
      if (row + offset < _board.length) {
        _board[row + offset][col + offset]++;
      }
      offset++;
    }
    return true;
  }

  /***
   * <general description>
   * precondition:
   * postcondition:
   */
  public String toString() {
    String ans = "";
    for (int r = 0; r < _board.length; r++) {
      for (int c = 0; c < _board[0].length; c++) {
        ans += _board[r][c] + "\t";
      }
      ans += "\n";
    }
    return ans;
  }

  // main method for testing...
  public static void main(String[] args) {
    QueenBoard b = new QueenBoard(8);
    System.out.println(b);

    b.solve();
    System.out.println(b);
    b.printSolution();

  }

}// end class
