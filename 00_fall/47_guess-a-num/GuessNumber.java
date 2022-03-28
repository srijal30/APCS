/*
COMPILE TIME ERRORS = SALAJ RIJAL, ARIEL FUCHS, MICHAEL KAMELA
APCS
HW 14 -- Guess Again -- Create guess my number game with rec and iter
2021-12-14
time spent: .8 hours

DISCO:

QCC:


*/

/***
 * class GuessNumber -- fun fun fun!
 *
 * SKELETON
 *
 * eg, sample interaction with end user:
 *
 * Guess a # fr 1-100: 50
 * Too high
 * Guess a # fr 1-49: 25
 * Too low
 * Guess a # fr 26-49: 38
 * Correct! It took 3 guesses
 ***/

import java.util.Scanner;

public class GuessNumber
{

  //instance vars
  private int _lo, _hi, _guessCtr, _target;
  Scanner sc = new Scanner( System.in );


  /*==================================================
    constructor -- initializes a guess-a-number game
    pre:  
    post: _lo is lower bound, _hi is upper bound,
    _guessCtr is 1, _target is random int on range [_lo,_hi]
    ==================================================*/
  public GuessNumber( int a, int b )
  {
    _lo = Math.min(a,b);
    _hi = Math.max(a,b);
    _guessCtr = 1;

    _target = _lo + (int) (Math.random() * (_hi-_lo) );
   }


  /*==================================================
    void playRec() -- Prompts a user to guess until guess is correct.
    Uses recursion.
    ==================================================*/
  public void playRec()
  {
    System.out.print("Guess a num bt " + _lo + " & " + _hi + ": ");
    int guess = sc.nextInt();
    if( guess == _target ){
        System.out.println("You Got it Right in " + _guessCtr + " number of tries!");
        return;
    }
    if( guess > _target ){
        System.out.println("Guess is too high!");
        _hi = guess;
    }
    else{
        System.out.println("Guess is too low!");
        _lo = guess;
    }
    _guessCtr++;
    playRec();
  }


  /*==================================================
    void playIter() -- Prompts a user to guess until guess is correct.
    Uses iteration.
    ==================================================*/
  public void playIter()
  {

    System.out.print("Guess a num bt " + _lo + " & " + _hi + ": ");
    int guess = sc.nextInt();

    while( guess != _target ) {
      if( guess > _target ){
          _hi = guess;
      }
      else{
          _lo = guess;
      }
      System.out.print("Guess a num bt " + _lo + " & " + _hi + ": ");
      guess = sc.nextInt();
      _guessCtr++;
    }

    System.out.println("You have guessed the number in " + _guessCtr + " tries!");
}


  //wrapper for playRec/playIter to simplify calling
  public void play()
  {
    //use one or the other below:
    //playRec();
    playIter();
  }


  //main method to run it all
  public static void main( String[] args )
  {
      //instantiate a new game
      GuessNumber g = new GuessNumber(1,100);
      //start the game
      g.play();
      /*-----------------------------
    -----------------------------*/
  }

}//end class GuessNumber