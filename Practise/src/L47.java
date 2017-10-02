import java.util.ArrayList;
import java.util.List;

/**
 * Created by Swathi on 8/18/2017.
 */
public class L47 {

    public static void main(String[] args){
        permuteUnique(new int[]{1,1,2});
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res =  new ArrayList<>();
        List<List<Integer>> mem =  new ArrayList<>();
        backtrack(res,nums,new ArrayList<>(),mem);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, int[] nums, List<Integer> prev, List<List<Integer>> mem){
        if(prev.size()==nums.length){
            res.add(new ArrayList<>(prev));
        }else{
            for(int i=0;i<nums.length;i++){
                List<Integer> tmp = new ArrayList<>(prev);
                tmp.add(nums[i]);
                if(!mem.contains(tmp)){
                    backtrack(res,nums,tmp,mem);
                    mem.add(tmp);
                }
            }
        }
    }
}
