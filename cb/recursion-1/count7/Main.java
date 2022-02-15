/*
Flying Sullen Actors: Salaj Rijal, Alif Rahman, Faiyaz Rafee
APCS
HW 64 -- Revisitation -- Coding Bat Practice
2022-2-14
time: 1 hour
*/

// https://codingbat.com/prob/p101409

public class Main {
    public static void main(String[] args) {
        System.out.println(count7(717)); // 2
        System.out.println(count7(7)); // 1
        System.out.println(count7(123)); // 0
    }

    /*
     *Given a non-negative int n, return the count of
      the occurrences of 7 as a digit, so for example
       717 yields 2. (no loops). Note that mod (%) by
        10 yields the rightmost digit (126 % 10 is 6),
         while divide (/) by 10 removes the rightmost
         digit (126 / 10 is 12).
     */

     public static int count7(int n) {
       if (n%10 == 7  && n < 10) {
         return 1;
       }
       else if  ( n < 10){
         return 0;
       }

       else if ( n%10 == 7){
         return 1 + count7(n/10);
       }

       return count7(n/10);
     }
}
