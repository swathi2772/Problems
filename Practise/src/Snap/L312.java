package Snap;

/**
 * Created by Swathi on 9/24/2017.
 */
public class L312 {
    public static void main(String[] args){
        System.out.println(maxCoins(new int[]{3,1,5,8}));
    }
    public static int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;


        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k) {
            System.out.println("k: "+k);
            for (int left = 0; left < n - k; ++left) {
                System.out.println("left: "+left);
                int right = left + k;
                System.out.println("right: "+right);
                for (int i = left + 1; i < right; ++i) {
                    System.out.println("i: "+i);
                    System.out.println("nums[left] * " +
                            "nums[i] * nums[right] + dp[left][i] + dp[i][right]: "+nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);


                    dp[left][right] = Math.max(dp[left][right],
                            nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
