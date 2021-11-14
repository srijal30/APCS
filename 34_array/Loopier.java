public class Loopier{

  public static String arrayToString( int[] array){
    /**
     * converts an int array to a string
     */
    String result = "[";
    for(int number: array){
      result += Integer.toString(number) + ", ";
    }
    result = result.substring(0, result.length()-2) + "]";
    return result;
  }

  public static void populate( int[] array ){
    /**
     * populates an int array with random integers
     */
    for(int i=0; i < array.length; i = i + 1){
        array[i] = (int) ( Math.random() * Math.pow(2, 32) );
    }
  }



  public static void main(String[] args) {
    //test of arrayToString
    int[] michael = {1, 2, 3, 4, 5, 6, 7, 8, 69};
    System.out.println( arrayToString(michael) );

    //test of populate
    int[] salaj = new int[10];
    populate(salaj);
    System.out.println( arrayToString(salaj) );
  }
}
