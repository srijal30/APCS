package SummerAssignments;
public class Loops {
    //Chapter 7: Loops
    public static void main(String[] args){
        //Test for power()
        System.out.println(power(2,2));
        System.out.println(power(2,3));
        System.out.println(power(4,5));
        System.out.println(power(-7,3));
        System.out.println();

        //Test for factorial()
        System.out.println(factorial(2));
        System.out.println(factorial(3));
        System.out.println(factorial(4));
        System.out.println(factorial(5));
        System.out.println();

        //Test for check() {and myexp() too}
        System.out.printf("%12s%12s%12s%n", "Base", "Default", "Custom"); //Top Titles
        //For 2
        check(2, 1);
        check(2, 10);
        check(2, 100);
        //For 3
        check(3, 1);
        check(3, 10);
        check(3, 100);
        //For 4
        check(4, 1);
        check(4, 10);
        check(4, 100);
    }
    //Exercise 3
    /**
     * 
     * @param base
     * @param power
     * @return double value of base^power
     */
    static double power(double base, int power){
        double result = base;
        for(int i=1; i<power; i++){
            result = result * base;
        }

        return result;

    }
    //Exercise 4
    /**
     * @param number
     * @return the facotorial calculation for number
     */
    static double factorial(double number){
        double result = 1;
        for(int i=1; i<number+1 ;i++){
            result *= i;
        }

        return result;
    }
    //Exercise 5
    /**
     * @param x
     * @param n
     * @return an estimation of e^x using the first n terms in the infinites series expansion
     * 
     */
    static double myexp(double x, int n){
        double result = 1d + x;
        double currentPower = x;
        double currentFactorial = 1d;
        for(int i=2; i<n+1; i++){
            //result += power(x, i)/factorial(i); old way
            currentPower *= x;
            currentFactorial *= i;
            result += currentPower/currentFactorial;
        }
        return result;
    }

    //Check Exercise 5
    /**
     * @param x
     * @param n
     * does stuff
     * 
     */
    static void check(double x, int n){
        System.out.printf("%12.5f%12.5f%12.5f%n", x, Math.exp(x), myexp(x, n));
    
    }
}
