public class sameFirstLast{
  public static boolean sameFirstLast(int[] nums){
    return (nums.length>0 && nums[0]==nums[nums.length-1]);
  }
  public static void main(String[] args) {
    System.out.println( sameFirstLast( new int[] {1, 2, 3}) );
    System.out.println( sameFirstLast( new int[] {1, 2, 3, 1}) );
    System.out.println( sameFirstLast( new int[] {1, 2, 1}) );

  }
}
