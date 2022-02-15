/*
Flying Sullen Actors: Salaj Rijal, Alif Rahman, Faiyaz Rafee
APCS
HW 64 -- Revisitation -- Coding Bat Practice
2022-2-14
time: 1 hour
*/
// https://codingbat.com/prob/p154669

public class Main {
    public static void main(String[] args) {
        System.out.println(factorial(1)); // 1
        System.out.println(factorial(2)); // 2
        System.out.println(factorial(3)); // 6
    }

    /*
     * Given n of 1 or more, return the factorial of n,
     * which is n * (n-1) * (n-2) ... 1. Compute the 
     * result recursively (without loops).
     */
    public static int factorial(int n) {
        if (n == 1) {
          return 1;
        }
        return n * factorial(n-1);
      }
}
