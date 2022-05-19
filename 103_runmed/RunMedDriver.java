import java.util.Scanner;

public class RunMedDriver
{
  public static void main( String[] args )
  {
      
    RunMed r = new RunMed();

    int n;
    Scanner sc = new Scanner( System.in );

    while( sc.hasNextInt() ) {
      try {
        n = sc.nextInt();
        //System.out.print("read " + n + "\n");

        //System.out.print("this many ints have been seen: " + count + "\n");

        r.add(n);
        //median = r.getMedian();
        //System.out.print("median is now " + median + "\n");
      
      } catch (Exception e) {
        System.out.println(e);
        System.err.println("BOOP! probs w yer input:\n"+e);
      }
    }

    System.out.println( r.getMedian() );


  }//end main

}//end class
