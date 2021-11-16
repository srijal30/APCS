public class firstLast6{
  public static boolean firstLast6(int[] nums){
    return(nums[0]==6||nums[nums.length-1]==6);
  }
  public static void main(String[] args) {
    int[] nums = {6,4,5,3,78};
    int[] nums2 = {4,435,5,34326,5};
    System.out.println(firstLast6(nums));
    System.out.println(firstLast6(nums2));
  }
}
