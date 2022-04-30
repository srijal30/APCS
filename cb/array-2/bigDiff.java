public class bigDiff {

    public static int bigDiff(int[] nums){
        int big = nums[0], small = nums[0];
        for(int num: nums){
            big = Math.max(big, num);
            small = Math.min(small, num);
        }
        return big-small;
    }

    public static void main(String[] args) {
        System.out.println( bigDiff( new int[]{10, 3, 5, 6} ) );        
        System.out.println( bigDiff( new int[]{7, 2, 10, 9} ) );    
        System.out.println( bigDiff( new int[]{2, 10, 7, 2} ) );    

    }
}
