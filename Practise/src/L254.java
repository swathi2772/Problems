import java.util.ArrayList;
import java.util.List;

/**
 * Created by Swathi on 8/17/2017.
 */
public class L254 {
    public static void main(String[] args){
        getFactors(12);
    }
    public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,new ArrayList<Integer>(), n, n);
        return res;
    }

    private static void backtrack(List<List<Integer>> res,List<Integer> prev, int n, int initial){
        if(n!=initial){
            int prod = n;
            for(Integer i:prev){
                prod*=i;
            }
            if(prod==initial){
                List<Integer> tmp = new ArrayList<>(prev);
                tmp.add(n);
                res.add(tmp);
            }
        }
        int divisor = 2;
        while(divisor<=Math.sqrt(n)){

            if(n%divisor==0){
                List<Integer> tmp = new ArrayList<Integer>(prev);
                tmp.add(divisor);
                backtrack(res,tmp,n/divisor,initial);
            }
            divisor++;
        }
    }
}
