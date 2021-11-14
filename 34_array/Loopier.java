public class Loopier{

  public static void printArray( int[] array){
    String result = "[";
    for(int number: array){
      result += Integer.toString(number) + ", ";
    }
    result = result.substring(0, result.length() - 2) + "]";
    System.out.println(result);
  }

  public static void populate( int[] array ){
    for(int i=0; i < array.length; i = i + 1){
        array[i] = Math.random() * Math.pow(2, 32);
    }
  }

  public static void main(String[] args) {
    int[] michael = {1, 2, 3, 4, 5, 6, 7, 8, 69};
    printArray( michael);

    int several = 10;
    int[] salaj = new int[several];

    populate(salaj)
  }
}
