public class centeredAverage {
    
    public static int centeredAverage(int[] nums) {
        int max = nums[0], min = nums[0], sum = 0;
        for( int num: nums){
            sum += num;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return (sum-max-min)/(nums.length-2);
    }

    public static void main(String[] args) {
        System.out.println( centeredAverage( new int[]{1, 2, 3, 4, 100} ) );
        System.out.println( centeredAverage( new int[]{1, 1, 5, 5, 10, 8, 7} ) );
        System.out.println( centeredAverage( new int[]{-10, -4, -2, -4, -2, 0} ) );

    }
}
