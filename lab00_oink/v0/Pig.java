/***
Pigs CAN fly: Salaj Rijal, Perry Huang, Andrew
APCS
HW<nn> -- <Title/Topic/Summary... (Aim for concision, brevity, CLARITY. Write to your future self...)>
<yyyy>-<mm>-<dd>
time spent: <elapsed time in hours, rounded to nearest tenth>
 *
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.    return w.indexOf(w) >= 0;
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/


public class Pig {

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
  
  
    /**
      String firstVowel(String) -- returns first vowel in a String
      pre:  w != null
      post: firstVowel("") --> ""
      firstVowel("zzz") --> ""
      firstVowel("meatball") --> "e"
      **/
    public static String firstVowel( String w ) {
      String ans = "";
  
      if ( hasAVowel(w) ) //Q: Why this necess?
        ans = allVowels(w).substring(0,1);
  
      return ans;
    }
  
  
    /**
      boolean beginsWithVowel(String) -- tells whether a String begins with a vowel
      pre:  w != null and w.length() > 0
      post: beginsWithVowel("apple")  --> true
      beginsWithVowel("strong") --> false
      **/
    public static boolean beginsWithVowel( String w ) {
      return isAVowel( w.substring(0,1) );
    }
  
  
    /**
      String engToPig(String) -- converts an English word to Pig Latin
      pre:  w.length() > 0
      post: engToPig("apple")  --> "appleway"
      engToPig("strong") --> "ongstray"
      engToPig("java")   --> "avajay"
      **/
    public static String engToPig( String w ) {
  
      String ans = "";
  
      if ( beginsWithVowel(w) )
        ans = w + "way";
  
      else {
        int vPos = w.indexOf( firstVowel(w) );
        ans = w.substring(vPos) + w.substring(0,vPos) + "ay";
      }
  
      return ans;
    }
  
    public static String translate() {
      return "";
    }
  
  
  
    public static void main( String[] args ) {
  
      for( String word : args ) {
        /*
        System.out.println( "allVowels \t" + allVowels(word) );
        System.out.println( "firstVowels \t" + firstVowel(word) );
        System.out.println( "countVowels \t" + countVowels(word) );
        System.out.println( "hasAVowel \t" + hasAVowel(word) );
        */
        System.out.println( "engToPig \t" + engToPig(word) );
      }
  
    }//end main()
  
  }//end class Pig
  