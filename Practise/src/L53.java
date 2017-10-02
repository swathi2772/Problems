/**
 * Created by Swathi on 8/14/2017.
 */
public class L53 {
    public static void main(String[] args){
        int a = maxSubArray(new int[]{-2,-1});
        System.out.println(a);
    }
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int max = sum;
        int i=0;
        int j = nums.length-1;
        int leftsum = 0;
        int rightsum = 0;
        while(nums.length>1&&i<=j){
            int l = i;
            int m = j;
            while(l<=m&&leftsum>=0&&rightsum>=0){
                leftsum+=nums[l];
                rightsum+=nums[m];
                l++;
                m--;
            }

            if(leftsum<0&&rightsum<0){
                if(leftsum<rightsum){
                    sum = sum-leftsum;
                    i=l;
                }else if(leftsum>rightsum){
                    sum = sum-rightsum;
                    j=m;
                }else{
                    break;
                }
            }else if(leftsum<0){
                sum = sum-leftsum;
                i=l;
            }else if(rightsum<0){
                sum = sum-rightsum;
                j=m;
            }else{
                i=l;
                j=m;
            }
            max= Math.max(max,sum);
            leftsum=0;
            rightsum=0;
        }
        return max;
    }
}
