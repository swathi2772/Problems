import java.util.Stack;

/**
 * Created by Swathi on 8/13/2017.
 */
public class L42 {
    public static void main(String[] args){
        trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
    public static int trap(int[] A){
        int a=0;
        int b=A.length-1;
        int max=0;
        int leftmax=0;
        int rightmax=0;
        while(a<=b){
            System.out.println("a: "+a+" b: "+b);
            leftmax=Math.max(leftmax,A[a]);
            rightmax=Math.max(rightmax,A[b]);
            System.out.println("leftmax: "+leftmax+" rightmax: "+rightmax);
            if(leftmax<rightmax){
                max+=(leftmax-A[a]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                a++;
            }
            else{
                max+=(rightmax-A[b]);
                b--;
            }
            System.out.println("max: "+max);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        return max;
    }
}
