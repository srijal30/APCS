/*
Flying Sullen Actors: Salaj Rijal, Alif Rahman, Faiyaz Rafee
APCS
HW 64 -- Revisitation -- Coding Bat Practice
2022-2-14
time: 1 hour
*/

// https://codingbat.com/prob/p183649

public class Main {
    public static void main(String[] args) {
        System.out.println(bunnyEars(0)); // 0
        System.out.println(bunnyEars(1)); // 2
        System.out.println(bunnyEars(2)); // 4
    }

    /*
     * We have a number of bunnies and each bunny has
     two big floppy ears. We want to compute the total
     number of ears across all the bunnies recursively
     (without loops or multiplication).Given n of 1 or more,
     return the bunnyEars of n,
     */
    public static int bunnyEars(int n) {
      if (n == 0) {
        return 0;
      }
      return 2 + bunnyEars(n-1);
    }
}
