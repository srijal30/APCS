/*
Flying Sullen Actors: Salaj Rijal, Alif Rahman, Faiyaz Rafee
APCS
HW 64 -- Revisitation -- Coding Bat Practice
2022-2-14
time: 1 hour
*/
// https://codingbat.com/prob/p120015

public class Main {
    public static void main(String[] args) {
        System.out.println(triangle(0)); // 0
        System.out.println(triangle(1)); // 1
        System.out.println(triangle(2)); // 3
    }

    /*
     * We have triangle made of blocks. The topmost
      row has 1 block, the next row down has 2 blocks
      , the next row has 3 blocks, and so on. Compute
       recursively (no loops or multiplication) the
        total number of blocks in such a triangle with
         the given number of rows.
     */

     public static int triangle(int n) {
       if (n == 0) {
         return 0;
       }
       return n + triangle(n-1);
     }
}
