package SummerAssignments;
public class Methods {
    //Chapter 5: Value Methods

    public static void main(String[] args){
        //Tests for isDivisible()
        System.out.println(isDivisible(8,2));
        System.out.println(isDivisible(-8, -2));
        System.out.println(isDivisible(0, 15));
        System.out.println(isDivisible(5, 13));

        //Tests for isTriangle()
        System.out.println();
        System.out.println(isTriangle(4, 4, 4));
        System.out.println(isTriangle(2, 2, 200));
        System.out.println(isTriangle(3, 4, 5));

        //Test for ack()
        System.out.println();
        System.out.println(ack(1, 0));
        System.out.println(ack(1, 1));
        System.out.println(ack(2, 1));
        System.out.println(ack(2, 2));
        System.out.println(ack(3, 2));
        System.out.println(ack(3, 3));
        //System.out.println(ack(4, 3)); //For fun.... was a bad idea

    }

    //Exercise 2
    /**
     * 
     * @param n dividend
     * @param m divisor
     * @return whether n is divisible by m
     */
    static boolean isDivisible(int n, int m){
        return n%m == 0;
    }

    //Excercise 3
    /**
     * 
     * @param a
     * @param b
     * @param c
     * @return whether a triange can be made from given side lengths a, b and c
     */
    static boolean isTriangle(int a, int b, int c){
        if (a + b < c) return false;
        else if (a + c < b) return false;
        else if (c + b < a) return false;
        return true;

    }

    //Excersize 8
    /**
     * The Ackermann function
     * @param m
     * @param n
     * @return 
     */
    static int ack(int m, int n){
        if (m == 0) {
            return n += 1;
        }
        else if (m>0 && n==0){
            return ack(m-1,1);
        }
        else if(m>0 && n>0){
            return ack(m-1, ack(m, n-1));
        }

        return 0;

    }
    
}
