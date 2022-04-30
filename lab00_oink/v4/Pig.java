/**
TNPG: Pigs Can Fly (Perry Huang, Salaj Rijal, Faiyaz Rafee, Andrew Piatetsky) and Burnt Peanut
APCS
Lab00 -- Etterbay Odingcay Oughthray Ollaborationcay/String manipulation and iteration and recursion/Create a pig latin translator.
2021-11-09
time spent: .8 hour + 1 hour + .5 hour

Discoveries:
-Taking a problem step by step is easier than solving everything at once.
-Creating methods to traverse a string becomes easier with practice
-Substring kind of allows us to turn each string into a list of letters
-In order to use scanner, you need to import it and then create and instance of class Scanner
-To immplement scanner, we made it so that while there were still characters left to process, a loop
would go throught and 

Questions:
-How would we implement special cases?
-Are there any built in methods that could help us?
-How can we check if our solutions are correct using the solutions given in excel?

class Pig
a Pig Latin translator
 **/

import java.util.Scanner;

public class Pig
{
  private static final String VOWELS = "aeiouy";
  private static final String CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final String LOWERS = "abcdefghijklmnopqrstuvwxyz";
  private static final String PUNCS = "!.?;:,";
  
  //Conditional Methods
  public static boolean hasA( String w, String letter ) {
    /*
    *checks for letter in a string
    */
    for (int index = 0; index < w.length(); index ++) {
      if (w.substring(index,index+1).equals(letter)) {
        return true;
      }
    }
    return false;
  }
 
  public static boolean isAVowel( String letter ) {
    /*
    *tells wheter a letter is a vowel
    */
    return hasA(VOWELS, toLower(letter)/*letter.toLowerCase()*/);
  }
  
  public static boolean isUpperCase( String letter ) { 
    /*
    *checks to see if the letter is a capital letter by using CAPS
    */
    return hasA(CAPS, letter);
  }

  public static boolean isLowerCase( String letter) {
    /*
    *checks to see if the letter is a lowercase letter by using LOWERS
    */
    return hasA(LOWERS, letter);
  }

  public static boolean isPunc (String letter){
    /*
    *checks if letter is a punctuation mark defined in PUNCS
    */
    return hasA(PUNCS, letter);
  }

  public static boolean beginsWithV ( String w ) {
		/*
    *returns true if the sentence begins with a vowel
    */
    return isAVowel( w.substring(0,1) );
  }
  
  public static boolean beginsWithUpper ( String w ) {
    /*
    *checks to see if first letter is a capital and returns true if it is
    */
    return isUpperCase(w.substring(0, 1));
  }
  
  //Indexing Methods
  public static int indexOfSpace ( String w ) {
    /*
    *returns index of the next space and -1 if no more spaces
    */
    for (int index = 0; index < w.length(); index ++) {
      if (" ".equals(w.substring(index,index+1))) {
        return index;
      }
    }
    return -1;
  }
  
  public static int firstVowel ( String w ) {
    /*
    *finds index of first vowel (linear search)
    */
    for (int index = 0; index < w.length(); index ++) {
      if ( isAVowel(w.substring(index,index+1)) ) {
        return index;
      }
    }
    return -1;
  }
 
  //Translating Methods
  public static String toUpper (String w) {
    /*
    *converts all letters of w to uppercase
    */
    String result = "";
    for(int i = 0; i < w.length(); i++){
      String letter = w.substring(i, i+1);
      if( isLowerCase(letter) ){
        int index = LOWERS.indexOf(letter);
        result += CAPS.substring(index, index+1);
      }
      else{
        result += letter;
      }
    }
    return result;
  }
  
  public static String toLower (String w) {
    /*
    *converts all uppercase letters in w to lowercase using LOWERS
    */
    String result = "";
    for(int i = 0; i < w.length(); i++){
      String letter = w.substring(i, i+1);
      if( isUpperCase(letter) ){
        int index = CAPS.indexOf(letter);
        result += LOWERS.substring(index, index+1);
      }
      else{
        result += letter;
      }
    }
    return result;
  }
  
  public static String wordToPig( String w ) {
    String punct = "";
    String firstLetter = "";
    if( isPunc(w.substring(w.length()-1)) ){
      punct = w.substring(w.length()-1);
      w = w.substring(0, w.length()-1);
    }
    if( beginsWithV(w) ) return w + "way" + punct;
    if( firstVowel(w) < 0) return w + "ay" + punct;
    int indexOfV = firstVowel(w);
    firstLetter = w.substring( indexOfV, indexOfV + 1);
    if( isUpperCase(w.substring(0, 1)) ) firstLetter = toUpper(firstLetter);
    return firstLetter + toLower( w.substring(indexOfV + 1) ) + toLower( w.substring(0, indexOfV) ) + "ay" + punct;
  } //end wordToPig

  public static String engToPig( String w ) {
    //Base Case
    if( indexOfSpace(w) < 0 ){
      return wordToPig(w);
    }
    //Recursive Reduction
    String firstWord = w.substring(0, indexOfSpace(w));
    String recursiveReduction = w.substring(indexOfSpace(w) + 1);
    return wordToPig(firstWord) + " " + engToPig(recursiveReduction);
  }

  //Main
  public static void main( String[] args ) {
    //instantiate a Scanner with STDIN as its bytestream
    Scanner sc = new Scanner( System.in );
    int line = 1;
    while( sc.hasNext() ) {
      String phrase = sc.nextLine();
      System.out.println( line++ + ": " + engToPig(phrase) );
    }

  }//end main()
}//end class Pig