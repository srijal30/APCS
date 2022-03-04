// Clyde Sinclair
// APCS pd0
// HW69 -- maze solving (blind, depth-first)
// 2022-03-03r
// time spent:  hrs

/***
 * SKEELTON for
 * class MazeSolver
 * Implements a blind depth-first exit-finding algorithm.
 * Displays probing in terminal.
 * 
 * USAGE: 
 * $ java Maze [path/to/mazefile]
 * (mazefile is ASCII representation of a maze, using symbols below)
 *
 * ALGORITHM for finding exit from starting position:
 *  
 * 
 * DISCO
 * 
 * QCC
 * 
 ***/

//enable file I/O
import java.io.*;
import java.util.*;


class MazeSolver
{
  final private int FRAME_DELAY = 50;

  private char[][] _maze;
  public int h, w; // height, width of maze
  private boolean _solved;

  //~~~~~~~~~~~~~  L E G E N D  ~~~~~~~~~~~~~
  final private char HERO =           '@';
  final private char PATH =           '#';
  final private char WALL =           ' ';
  final private char EXIT =           '$';
  final private char VISITED_PATH =   '.';
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  public MazeSolver( String inputFile )
  {
    // init 2D array to represent maze
    // (80x25 is default terminal window size)
    _maze = new char[100][100];
    h = 0;
    w = 0;

    //transcribe maze from file into memory
    try {
      Scanner sc = new Scanner( new File(inputFile) );

      System.out.println( "reading in file..." );

      int row = 0;

      while( sc.hasNext() ) {

        String line = sc.nextLine();

        if ( w < line.length() )
          w = line.length();

        for( int i=0; i<line.length(); i++ )
          _maze[i][row] = line.charAt( i );

        h++;
        row++;
      }

      for( int i=0; i<w; i++ )
        _maze[i][row] = WALL;
      h++;
      row++;

    } catch( Exception e ) { System.out.println( "Error reading file" ); }

    //at init time, maze has not been solved:
    _solved = false;
  }//end constructor


  /**
   * "stringify" the board
   **/
  public String toString()
  {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = "[0;0H";
    //emacs shortcut: C-q, ESC
    //emacs shortcut: M-x quoted-insert, ESC

    int i, j;
    for( i=0; i<h; i++ ) {
      for( j=0; j<w; j++ )
        retStr = retStr + _maze[j][i];
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
   * void solve(int x,int y) -- recursively finds maze exit (depth-first)
   * @param x starting x-coord, measured from left
   * @param y starting y-coord, measured from top
   **/
  public void solve( int x, int y )
  {
    delay( FRAME_DELAY ); //slow it down enough to be followable
    
    //check if on path
    if( ! onPath(x, y) ){
      return;
    }
    
    //check if _solved becomes true
    if( _maze[x][y] == EXIT ) {
      //do we need to add code to move player here
      delay(1000);
      System.out.println("SOLVED!");
      _solved = true;
      return;
    }
     
    //deactivate if solved
    if ( _solved ) {
      delay(1000);
      System.out.println("MAZE SOLVED!");
      System.exit(0);
    }

    //checks if invalid object
    if ( _maze[x][y] ==  WALL || _maze[x][y] == VISITED_PATH || _maze[x][y] == HERO) {
      return;
    }
    
    //otherwise, recursively solve maze from next pos over,
    //after marking current location
    else {
      //set current tile to hero tile
      _maze[x][y] = HERO;
      
      System.out.println( this ); //refresh screen

      solve(x - 1, y); //up
      solve(x, y - 1); //left
      solve(x, y + 1); //right
      solve(x + 1, y); //down

      System.out.println( this ); //refresh screen
      //set period
      _maze[x][y] = VISITED_PATH;
    }
    
  }

  //accessor method to help with randomized drop-in location
  public boolean onPath( int x, int y) {
    return _maze[x][y] == PATH;  
  }

}//end class MazeSolver


public class Maze
{
  public static void main( String[] args )
  {
    String mazeInputFile = null;

    try {
      mazeInputFile = args[0];
    } catch( Exception e ) {
      System.out.println( "Error reading input file." );
      System.out.println( "USAGE:\n $ java Maze path/to/filename" );
    }

    if (mazeInputFile==null) { System.exit(0); }

    MazeSolver ms = new MazeSolver( mazeInputFile );

    //clear screen
    System.out.println( "[2J" );

    //display maze
    System.out.println( ms );

    // ThinkerTODO: comment next line out when ready to randomize startpos
    //ms.solve( 0, 0 );

    //drop our hero into maze at random location on path
    int startX = (int) ( Math.random() * ms.h );
    int startY = (int) ( Math.random() * ms.w );

    //continously loop until valid position found
    while( ! ms.onPath(startX, startY) ){
      startX = (int) ( Math.random() * ms.h );
      startY = (int) ( Math.random() * ms.w );
    }

    ms.solve( startX, startY );
  }//end main()

}//end class Maze
