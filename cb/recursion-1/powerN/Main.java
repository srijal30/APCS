/*
Flying Sullen Actors: Salaj Rijal, Alif Rahman, Faiyaz Rafee
APCS
HW 64 -- Revisitation -- Coding Bat Practice
2022-2-14
time: 1 hour
*/
// https://codingbat.com/prob/p158888

public class Main {
    public static void main(String[] args) {
        System.out.println(powerN(3,1)); // 3
        System.out.println(powerN(3, 2)); // 9
        System.out.println(powerN(3, 3)); // 27
    }

    /*
     *Given base and n that are both 1 or more,
     compute recursively (no loops) the value of
     base to the n power, so powerN(3, 2) is 9 (3 squared).
     */

     public static int powerN(int base, int n) {
       if (n == 0) {
         return 1;
       } else {
         return base * powerN(base, n-1);
       }
}
}
