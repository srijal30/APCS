/*
Triumphant Triumvirate: Salaj Rijal: George, Ariel Fuchs: Skelly Ducky, Ben Belotser: TwoFace
APCS
HW 21 -- StatisTically Speaking -- Test the Class Stats provided for us.
2021-10-20

DISCO:
-You can use Math to help

QCC:
-Why are we not allowed to use typecasting?
-How would we convert from double to int without typecasting?
-What exactly is lossy conversion
-Why does Math.float() doesnt work
*/
public class Stats {

  public static int mean(int a, int b) {
		return ((a + b) / 2);
  }

  
  public static double mean(double a, double b) {
		return ((a + b) / 2);
  }

  
  public static int max(int a, int b) {
    if (a > b){
      return a;
    }
    if (b > a){
			return b;
    }
    return a;
    
  }

  public static double max(double a, double b) {
 		if (a > b){
      return a;
    }
    if (b > a){
			return b;
    }
    return a;
  }

  
  public static int geoMean(int a, int b) {
    return Math.round( Math.round( Math.sqrt(a*b) ) );
  }

  public static double geoMean(double a, double b) {
    return Math.pow(a*b, .5);

  }

  public static int max(int a, int b, int c) {
    if (a>b & a>c){
      return a;
    }
    if (b>c &b>a){
      return b;
    }
    if (c>b & c>a){
      return c;
    }
    return a; //if all are equal
  }

  public static double max(double a, double b, double c) {
    if (a>b & a>c){
      return a;
    }
    if (b>c){
      return b;
    }
    if (c>b){
      return c;
    }
    return a; //if all are equal
  }

  public static int geoMean(int a, int b, int c) {
		return Math.round( Math.round( Math.pow(a*b*c, 1/3.0) ) );
  }

  public static double geoMean(double a, double b, double c) {
		return Math.pow(a*b*c, 1/3.0);
  }

}//end class
