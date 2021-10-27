/*
Triumphant Triumvirate: Salaj Rijal, Ariel Fuchs, Ben Belotser
APCS
HW 26 -- GCD Three Ways -- Creating a gcd method using 3 different approache (brute force, iterative and recursive)
2021-10-27
time spent: .8 hours

DISCO:
-We can use the rule we learned in class to help us on our recursive solution
-We can use a return statement inside a while loop

QCC:
-Is there a better way to find which value is greater?
-Should this work for negative numbers as well? If so, how would we implement that?
-How can we tell java that we are expecting certain preconditions?
-What is the differnce between brute force and iterative? Wouldnt brute force be finding the factors
for each input and putting them in a list, and then searching the array for the largest common value?

ALGO:

*/
public class Stats {
    //Testing
    public static void main(String[] args) {
        //Tests for Brute Force Method
        System.out.println("Brute Force Tests:");
        System.out.println( gcd( 48, 18) + "...expecting 6");
        System.out.println( gcd( 48, 48) + "...expecting 48");
        System.out.println( gcd( 18, 18) + "...expecting 18");
        System.out.println( gcd( 18, 48) + "...expecting 6");
        //Tests for Recursive
        System.out.println("Recursive Tests:");
        System.out.println( gcdER( 48, 18) + "...expecting 6");
        System.out.println( gcdER( 48, 48) + "...expecting 48");
        System.out.println( gcdER( 18, 18) + "...expecting 18");
        System.out.println( gcdER( 18, 48) + "...expecting 6");
        //Tests for Iterative
        System.out.println("Iterative Tests");
        System.out.println( gcdEW( 48, 18) + "...expecting 6");
        System.out.println( gcdEW( 48, 48) + "...expecting 48");
        System.out.println( gcdEW( 18, 18) + "...expecting 18");
        System.out.println( gcdEW( 18, 48) + "...expecting 6");
    }
    //Brute Force
    public static int gcd(int a, int b){
        int result = 0; 
        int counter = 1;
        if(b==a){
            return b;
        }
        else if(b<a){
            while(counter<=b){
                if(b%counter==0 && a%counter==0){
                    result = counter;
                }
                counter++;
            }
        }
        else{
            while(counter<=a){
                if(b%counter==0 && a%counter==0){
                    result = counter;
                }
                counter++;
            }
        }
        return result;
    }
    //Recursive
    public static int gcdER(int a, int b){
        if(a==b){
            return a;
        }
        if(a>b){
            return gcdER(a-b,b);
        }
        return gcdER(b-a,a);
    }
    //Iterative
    public static int gcdEW(int a, int b){
        int counter;
        if(a>=b){
            counter = b;
        }
        counter = a;
        while(counter>0){
            if(a%counter==0 && b%counter==0){
                return counter;
            }
            counter--;
        }
        return 0;
    }
}
