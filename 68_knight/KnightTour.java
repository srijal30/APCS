// Clyde Sinclair
// APCS pd0
// HW68 -- recursively probing for a closed cycle
// 2022-02-28m
// time spent:  2 hours

/***
 * SKELETON
 * class KnightTour (and supporting class TourFinder)
 * Animates generation of a Knight's Tour on a square chess board.
 *
 * USAGE: (default N value: 8)
 * $ javac KnightTour.java
 * $ java KnightTour
 * $ java KnightTour [N]
 *
 * ALGO:
 * Place the knight in the top right square of the board. Try a random avaliable move for the knight. Check if the move either: a. finishes the tour or 
 * b. lands on an invalid square (out-of-bounds or on a previously visited square). If a, then you are finished. If b, then go back one step and try unexplored moves.
 * If you try all of the moves and still havent found a solution, then there are no solutions for that starting position, so try another starting position.
 * 
 * DISCO 
 * time command can help you benchmark how long it took for your code to run.
 * 
 * QCC
 * What is the minimum side length to produce a king's tour?
 * How do we change the initial position once we figure out there are no solutions for one?
 * What is the strategically the best starting position.
 * Will primary base case code ever run?
 
 * Mean execution times for boards of size n*n:
 * n=5   s    across 3 execution
 * n=6   s    across 3 execution
 * n=7   s    across 3 execution

 */
import java.io.*;
import java.util.*;


public class KnightTour
{
  public static void main( String[] args )
  {
    //size of board setup (default is 8)
    int n = 8; 
    try {
      n = Integer.parseInt( args[0] );
    } catch( Exception e ) {
      System.out.println( "Invalid input. Using board size " + n + "..." );
    }

    //create the root frame
    TourFinder tf = new TourFinder(n);

    //clear screen using ANSI control code
    System.out.println( "[2J" );

    //display board
    //System.out.println( tf );

    //FOR ONE STARTING SQUARE:
    //for fixed starting location, use line below:
    tf.findTour( 2, 2, 1 );
    //for random starting location, use lines below:
    //int startX = (int) (Math.random() * n);
    //int startY = (int) (Math.random() * n);
    //tf.findTour( startX, startY, 1 );   // 1 because it is the first move

    //PUSHING FARTHER:

  }//end main()

}//end class KnightTour


class TourFinder
{
  //instance vars
  private int[][] _board;
  private int _sideLength; 
  
  private boolean _solved = false;

  //constructor -- build board of size n x n
  public TourFinder( int n )
  {
    _sideLength = n;

    //init 2D array to represent square board with moat
    _board = new int[_sideLength+4][_sideLength+4];

    //make all squares initially -1
    for( int row = 0; row < _board.length; row++ )
      for( int col = 0; col < _board.length; col++ ) 
        _board[row][col]--;

    //carve out the actual board with 0's
    for( int row = 2; row < _board.length-2; row++ )
      for( int col = 2; col < _board.length-2; col++ ) 
        _board[row][col]++;
        
  }//end constructor


  /**
   * "stringify" the board
   **/
  public String toString(){
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = "[0;0H";
    //emacs shortcut: C-q, then press ESC
    //emacs shortcut: M-x quoted-insert, then press ESC
    int i, j;
    for( i=0; i < _sideLength+4; i++ ) {
      for( j=0; j < _sideLength+4; j++ )
        retStr = retStr + String.format( "%3d", _board[i][j] );
      //"%3d" allots 3 spaces for each number
      retStr = retStr + "\n";
    }
    return retStr;
  }

  /**
   * helper method to keep try/catch clutter out of main flow
   * @param n      delay in ms
   **/
  private void delay( int n )
  {
    try {
      Thread.sleep(n);
    } catch( InterruptedException e ) {
      System.exit(0);
    }
  }


  /**
   * void findTour(int x,int y,int moves) -- use depth-first w/ backtracking algo
   * to find valid knight's tour
   * @param x      starting x-coord
   * @param y      starting y-coord
   * @param moves  number of moves made so far
   **/
  public void findTour( int x, int y, int moves )
  {
    //delay(50); //slow it down enough to be followable

    //if a tour has been completed, stop animation
    if ( _solved ) System.exit(0);

    //primary base case: tour completed
    if (  moves > Math.pow(_sideLength, 2) ){
      System.out.println( this );
      _solved = true;
      return;
    }

    //other base case: stepped off board or onto visited cell
    //essentially wont continue
    if ( _board[x][y] != 0 ) {
      return;
    }

    //otherwise, mark current location
    //and recursively generate tour possibilities from current pos
    else {

      //mark current cell with current move number
      _board[x][y] = moves;

      //System.out.println( this ); //refresh screen

      //delay(1000); //uncomment to slow down enough to view

      /******************************************
       * 
       * Recursively try to "solve" (find a tour) from
       * each of knight's available moves.
       *     . e . d .
       *     f . . . c
       *     . . @ . .
       *     g . . . b
       *     . h . a .
      ******************************************/
      findTour( x+2 , y+1 , moves+1 ); //a
      findTour( x+1 , y+2 , moves+1 ); //b
      findTour( x-1 , y+2 , moves+1 ); //c
      findTour( x-2 , y+1 , moves+1 ); //d
      findTour( x-2 , y-1 , moves+1 ); //e
      findTour( x-1 , y-2 , moves+1 ); //f
      findTour( x+1 , y-2 , moves+1 ); //g
      findTour( x+2 , y-1 , moves+1 ); //h

      //If made it this far, path did not lead to tour, so back up...
      // (Overwrite number at this cell with a 0.)
      _board[x][y] = 0;

      //System.out.println( this ); //refresh screen

      return;
    }
  }//end findTour()

}//end class TourFinder
