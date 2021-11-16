public class countEvens{

    public static int countEvens(int[] nums) {
        int count = 0;
        for(int num: nums){
            if(num%2==0) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println( countEvens( new int[] {2, 1, 2, 3, 4} ) );
        System.out.println( countEvens( new int[] {2, 2, 0} ) );
        System.out.println( countEvens( new int[] {1, 3, 5} ) );


    }
}