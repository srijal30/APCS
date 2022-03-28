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
public class StatsDriver{
	public static void main(String[] args){
		Stats hippie = new Stats();
		System.out.println( hippie.mean(4, 6) + " ...expecting 5");
		System.out.println( hippie.mean(4.5 , 5.5) + " ...expecting 5.0");
		System.out.println( hippie.max(4, 5) + " ...expecting 5");
        System.out.println( hippie.max(4.5, 5.5) + " ...expecting 5.5");
        System.out.println( hippie.geoMean(4, 6) + " ...expecting 4");
        System.out.println( hippie.geoMean(4.5, 6.5) + " ...expecting 5.40833");
		System.out.println( hippie.max(4, 5, 6) + " ...expecting 6");
        System.out.println( hippie.max(4.5, 5.5, 6.5) + " ...expecting 6.5");
        System.out.println( hippie.geoMean(4, 6, 8) + " ...expecting 5");
        System.out.println( hippie.geoMean(4.5, 6.5, 8.5) + " ...expecting 6.28803");
    }
}