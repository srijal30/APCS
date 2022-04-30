/*
Iumphanttray Iumviratetray: Alajsay Ijalray, Arielyay Uchsfay, Enbay Elotserbay
APCS
HW 31 -- Otnay Ybay ethay Airhay Onway Ymay Inneechay Inchay Inchay -- Eatingcray Assclay Gpiay
2021-11-03
Imetay Entspay: 1 urhoay

(CHECK BOTTOM IF YOU NEED ENGLISH)

DISCO:
-ethay initializatinoyay ofyay owelsvay akesmay ouryay iveslay easieryay eway ancay eckchay ifyay ayay etterlay isyay 
in ethay ingstray otay etermineday ifyay ityay isyay ayay owelvay oryay otnay 
-ouyay ancay useyay ethodsmay atthay ouyay eviouslypray ademay otay elphay akemay otheryay ethodsmay (division ofyay labor)
-

QCC:
-ouldshay eway useyay tolowercase() insideyay omesay ofyay ethay ethodsmay ? ifyay osay , ichwhay onesyay ? 
-isyay ethay ortcutshay eway usedyay orfay asavowelhay appropriateyay ? 
-ancay eway avehay integratedyay ethay ethodsmay oremay ? 


*/
public class Pig
{
  private static final String VOWELS = "aeiou";

  public static boolean hasA( String w, String letter ) 
  {
      /**
       *eckchay ifyay ingstray etterlay isyay inyay ingstray w
       */
      for(int i = 0; i<w.length(); i++){
          if( w.substring(i, i+1).equals(letter) ){
              return true;
          }
      }
      return false;
  }

  public static boolean isAVowel( String letter ) 
  {
      /**
       *eckchay ifyay etterlay isyay ayay owelvay
       */
      letter = letter.toLowerCase();
      return hasA(VOWELS, letter);
  }

  public static int countVowels( String w ) 
  {
      /**
       *ountcay owhay anymay owelsvay areyay esentpray inyay ingstray w
       */
      int count = 0;
      for(int i = 0; i<w.length(); i++){
          if( isAVowel(w.substring(i,i+1)) ){
              count++;
          }
      }
    return count;
  }

  public static boolean hasAVowel( String w ) 
  {
    /**
    *eckchay ifyay ingstray w ashay ayay owelvay
    */
    return countVowels(w) != 0;
  }

  public static String allVowels( String w ) 
  {
    /**
     *eckschay ifyay allyay etterslay inyay ingstray w areyay owelsvay
     */
    String result = "";
    for(int i = 0; i < w.length(); i++){
        String letter = w.substring(i, i+1);
        if( isAVowel(letter) ){
            result += letter;
        }
    }
    return result;
  }
  
  public static void main( String[] args ) 
  {
      //hasA() tests
      System.out.println( "Tests for hasA(): ");
      System.out.println( hasA("dad", "d") + " ...expecting true");
      System.out.println( hasA("nay", "b") + " ...expecting false");
      System.out.println( hasA("daD", "D") + " ...expecting true");
      System.out.println( hasA("nay", "N") + " ...expecting false\n");
      //isAVowel() tests
      System.out.println( "Tests for isAVowel(): ");
      System.out.println( isAVowel("A") + " ...expecting true");
      System.out.println( isAVowel("e") + " ...expecting true");
      System.out.println( isAVowel("I") + " ...expecting true");
      System.out.println( isAVowel("o") + " ...expecting true");
      System.out.println( isAVowel("y") + " ...expecting false\n");
      //countVowels() tests
      System.out.println( "Tests for countVowels(): ");
      System.out.println(  countVowels("apcs") + " ...expecting 1");
      System.out.println(  countVowels("AEIOUaeiou") + " ...expecting 10");
      System.out.println(  countVowels("all roads lead to rome") + " ...expecting 8\n");
      //hasAVowel() tests
      System.out.println( "Tests for hasAVowel(): ");
      System.out.println( hasAVowel("cnstnts") + " ...expecting false");
      System.out.println( hasAVowel("vEry hppy") + " ...expecting true");
      System.out.println( hasAVowel("yes sir") + " ...expecting true\n" );
      //allVowels() test
      System.out.println( "Tests for allVowels(): ");
      System.out.println( allVowels("Anamonapia") + " ...expecting Aaoaia");
      System.out.println( allVowels("Salaj Rijal") + " ...expecting aaia");
      System.out.println( allVowels("Ariel Fuchs") + " ...expecting Aieu");
      System.out.println( allVowels("Ben Belotser") + " ...expecting eeoe");
  }
}//denay ofway assay

/* if you need english..
DISCO:
-the initialization is helpful because it makes it easier to check if something is a vowel with the hasA() method
-you can use methods that you previously made to help make other methods (division of labor)
-

QCC:
-should we use toLowerCase() inside some of the methods? if so, which ones?
-is the shortcut we used for hasAVowel Appropriate?
-can we have integrated the methods more?*/