/*
Flying sullen Actors: Alif Rahman, Faiyaz Rafee, Salaj Rijal
APCS
LAB 6 -- Read/Review/Expand -- Cobo Consumer Review Lab
2022-2-14
time spent: 4 hours
*/
import java.util.Scanner;
import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

/**
 * Class that contains helper methods for the Review Lab
 **/
public class Review {

  private static HashMap<String, Double> sentiment = new HashMap<String, Double>();
  private static ArrayList<String> posAdjectives = new ArrayList<String>();
  private static ArrayList<String> negAdjectives = new ArrayList<String>();


  private static final String SPACE = " ";

  public static void main(String[] args){
    //add to sentiment
    try {
      Scanner input = new Scanner(new File("cleanSentiment.csv"));
      while(input.hasNextLine()){
        String[] temp = input.nextLine().split(",");
        sentiment.put(temp[0],Double.parseDouble(temp[1]));
        //System.out.println("added "+ temp[0]+", "+temp[1]);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing cleanSentiment.csv");
    }
  //read in the positive adjectives in postiveAdjectives.txt
     try {
      Scanner input = new Scanner(new File("positiveAdjectives.txt"));
      while(input.hasNextLine()){
        String temp = input.nextLine().trim();
        // /System.out.println(temp);
        posAdjectives.add(temp);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
    }
  //read in the negative adjectives in negativeAdjectives.txt
     try {
      Scanner input = new Scanner(new File("negativeAdjectives.txt"));
      while(input.hasNextLine()){
        negAdjectives.add(input.nextLine().trim());
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing negativeAdjectives.txt");
    }
    System.out.println( totalSentiment("SimpleReview.txt"));
    System.out.println( starRating("SimpleReview.txt") );

    System.out.println(fakeReview("This was a *terrible restaurant! The pizza crust was too *chewy, and I disliked the *stale pasta. I would definitely not come back. The soda was pretty *good and *flavorful."));
  }

  /**
   * returns a string containing all of the text in fileName (including punctuation),
   * with words separated by a single space
   */
  public static String textToString( String fileName )
  {
    String temp = "";
    try {
      Scanner input = new Scanner(new File(fileName));

      //add 'words' in the file to the string, separated by a single space
      while(input.hasNext()){
        temp = temp + input.next() + " ";
      }
      input.close();

    }
    catch(Exception e){
      System.out.println("Unable to locate " + fileName);
    }
    //make sure to remove any additional space that may have been added at the end of the string.
    return temp.trim();
  }

  /**
   * @returns the sentiment value of word as a number between -1 (very negative) to 1 (very positive sentiment)
   */
  public static double sentimentVal( String word )
  {
    try
    {
      return sentiment.get(word.toLowerCase());
    }
    catch(Exception e)
    {
      return 0;
    }
  }

  /**
   * Returns the ending punctuation of a string, or the empty string if there is none
   */
  public static String getPunctuation( String word )
  {
    String punc = "";
    for(int i=word.length()-1; i >= 0; i--){
      if(!Character.isLetterOrDigit(word.charAt(i))){
        punc = punc + word.charAt(i);
      } else {
        return punc;
      }
    }
    return punc;
  }

    /**
   * Returns the word after removing any beginning or ending punctuation
   */
  public static String removePunctuation( String word )
  {
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(0)))
    {
      word = word.substring(1);
    }
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length()-1)))
    {
      word = word.substring(0, word.length()-1);
    }

    return word;
  }

  /**
   * Randomly picks a positive adjective from the positiveAdjectives.txt file and returns it.
   */
  public static String randomPositiveAdj()
  {
    int index = (int)(Math.random() * posAdjectives.size());
    return posAdjectives.get(index);
  }

  /**
   * Randomly picks a negative adjective from the negativeAdjectives.txt file and returns it.
   */
  public static String randomNegativeAdj()
  {
    int index = (int)(Math.random() * negAdjectives.size());
    return negAdjectives.get(index);

  }

  /**
   * Randomly picks a positive or negative adjective and returns it.
   */
  public static String randomAdjective()
  {
    boolean positive = Math.random() < .5;
    if(positive){
      return randomPositiveAdj();
    } else {
      return randomNegativeAdj();
    }
  }

//OUR MODS
public static double totalSentiment( String fileName ) {
  String content = textToString(fileName);
  double totalSentiment = 0;

  int index = 0;
  while( index < content.length() ){
    //keep going until space
    int temp = index;
    while( index < content.length() && content.charAt(index) != ' '){
      index++;
    }
    //clear punctuation and add sentiment value
    totalSentiment += sentimentVal( removePunctuation( content.substring(temp, index) ) );
    index++;
  }

  return totalSentiment;
}

public static int starRating(String fileName){
  double rating = totalSentiment(fileName);
  if( rating < -5 ){
    return 1;
  }
  else if ( rating < -2){
    return 2;
  }
  else if ( rating < 2){
    return 3;
  }
  else if( rating < 5){
    return 4;
  }
  return 5;
}

/* Code for Activity 3
public static String replaceAdjective(String fileName) {
  // helper functino for fakeReview
  int indexAst = fileName.indexOf("*");
  String partOne = fileName.substring(0, indexAst);
  String partTwo = fileName.substring(indexAst, fileName.length());
  int indexSpace;
  if (partTwo.indexOf(" ") > -1) {
    indexSpace = partTwo.indexOf(" ");
  } else {
    indexSpace = partTwo.length()-1;
  }
  partTwo = partTwo.substring(indexSpace);
  return partOne + randomAdjective() + partTwo;
}

public static String fakeReview(String fileName) {
  while (fileName.indexOf("*") > -1) {
    fileName = replaceAdjective(fileName);
  }
  return fileName;
}
*/

//For Activity 4:
public static String replaceAdjective(String fileName) {
  // helper functino for fakeReview
  int indexAst = fileName.indexOf("*");
  String partOne = fileName.substring(0, indexAst);
  String partTwo = fileName.substring(indexAst, fileName.length());
  int indexSpace;
  if (partTwo.indexOf(" ") > -1) {
    indexSpace = partTwo.indexOf(" ");
  } else {
    indexSpace = partTwo.length()-1;
  }
  String adjective = partTwo.substring(1, indexSpace);
  if (sentimentVal(adjective) < 0) {
   adjective = randomPositiveAdj();
  }
  partTwo = partTwo.substring(indexSpace);
  return partOne + adjective + partTwo;
}

public static String fakeReview(String fileName) {
  while (fileName.indexOf("*") > -1) {
    fileName = replaceAdjective(fileName);
  }
  return fileName;
}

}
