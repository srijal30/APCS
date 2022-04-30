// https://codingbat.com/prob/p111624

public class catDog {
    public static void main(String[] args) {
        System.out.println(catDog("catdog")); // true
        System.out.println(catDog("catcat")); // false
        System.out.println(catDog("1cat1cadodog")); // true
    }

    /*
     * Return true if the string "cat" and "dog" appear the same number of times
     * in the given string.
     */
    public static boolean catDog(String str) {
        int dogCount = 0;
        int catCount = 0;

        for(int i=0; i < str.length()-2; i++){
            String current = str.substring(i, i + 3);
            if(current.equals("dog")){
                dogCount++;
            }
            else if(current.equals("cat") ){
                catCount++;
            }
        }

        return catCount == dogCount;
    }
}
