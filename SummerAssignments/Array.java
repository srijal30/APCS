package SummerAssignments;
import java.util.Arrays;
import java.util.Random;

public class Array{
    public static void main(String[] args){
        //Test for powArray()
        System.out.println(powArray(new double[]{1,2,3,4,5}));
        System.out.println(powArray(new double[]{2,2,2,2,4}));
        System.out.println(powArray(new double[]{1,5,3}));
        System.out.println(powArray(new double[]{6,5,4,3,2,1,0,-1,-2,-3}));
        System.out.println();

        //Test for histogram()
        /*
        histogramCheck(10, 10, 10);
        histogramCheck(1, 10, 10);
        histogramCheck(5, 10, 10);
        histogramCheck(100, 100, 100); //The Classic example
        histogramCheck(10, 100, 100);
        System.out.println();
        */

        //Test for indexOfMax()
        indexOfMaxTest(10, 10);
        indexOfMaxTest(10, 10);
        indexOfMaxTest(10, 10);

        //Test for sieve()
        sieveTest(10);
        sieveTest(20);
        sieveTest(30);
        sieveTest(40);
        sieveTest(50);



    }
    
    //Exercise 1
    //Part 1
    static String powArray(double[] array){
        for(int i=0;i<array.length;i++){
            array[i] = Loops.power(array[i], 2);
        }
        return Arrays.toString(array);
    }

    //Part 2
    //Initilization of histogram()
    static int[] histogram(int[] scores, int counters, int maxValue){
        int[] countArray = new int[counters];
        //Loop through all the scores
        for(int score: scores){
            //Loop through all counters finding which counter a certain score belongs in 
            for(int i=0; i<=counters; i++){

                if( score >= maxValue/counters*i && score < maxValue/counters*(i+1) ){
                    countArray[i]++;
                    break; //for effiency
                }
            }
        }
        return countArray;
    }
    //To help test histogram()
    static void histogramCheck(int counters, int amount, int maxValue){
        Random random = new Random();
        int[] scores = new int[amount];
        //Creates array of randomly generated scores
        for(int i =0; i<amount; i++){
            scores[i] = random.nextInt(maxValue);
        }
        //Print the Array
        System.out.println(Arrays.toString(scores));
        //Create the histogram and print it
        System.out.println( Arrays.toString( histogram(scores, counters, maxValue) ) );
    }

    //Exercise 4
    //Loops through an array and sets the index of the current greatest value to value
    static int indexOfMax(int[] array){
        int value = 0;
        for(int i=0;i<array.length;i++){
            if(array[i] > value){
                value = array[i];
            }
        }
        return value;
    }
    //Help test indexOfMax()
    static void indexOfMaxTest(int maxValue, int amount){
        Random rng = new Random();
        int[] array = new int[amount];

        for(int i =0; i<amount; i++){
            array[i] = rng.nextInt(maxValue);
        }

        System.out.println( Arrays.toString(array) );

        System.out.println( indexOfMax(array));
    }

    //Exercise 5
    //Iteratively find all prime numbers in range 0 - n-1
    static boolean[] sieve(int n){
        //Initialization of boolean[] full of true values
        boolean[] bools = new boolean[n];
        for(int i=2;i<n;i++){
            bools[i] = true;
        }

        for(int i=0;i<n;i++){
            //check if already defined as not prime
            if(!bools[i]){
                continue;
            }
            //all multiples of the prime number will be turned false
            for(int x=i+i;x<n;x+=i){
                bools[x]=false;
            }

        }
        return bools;

    }
    //Help test sieve()
    static void sieveTest(int n){

        System.out.println( Arrays.toString(sieve(n)) );

    }


    
}
