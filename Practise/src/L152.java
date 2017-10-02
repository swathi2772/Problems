/**
 * Created by Swathi on 8/16/2017.
 */
public class L152 {
    public static void  main(String[] args){
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
    }
    public static int maxProduct(int[] nums) {
        int max = -Integer.MAX_VALUE;
        int prod = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0){
                if(prod>max){
                    max = prod;
                }
                prod = 1;
            }else{

                prod =prod*nums[i];
            }
        }
        return max;
    }
}
