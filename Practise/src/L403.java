import java.util.*;

/**
 * Created by Swathi on 9/20/2017.
 */
public class L403 {
    public static boolean canCross(int[] stones) {
        Map<int[],Boolean> set = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i:stones){
            list.add(i);
        }
        return dp(list,set,1,1,stones[stones.length-1]);
    }

    public static boolean dp(List<Integer> stones,Map<int[],Boolean> map,int pos, int prev_jump, int end){
        if(!stones.contains(pos))
            return false;
        if(pos==end)
            return true;
        int[] key = {pos,prev_jump};
        if(map.containsKey(key)){
            return map.get(key);
        }
        boolean flag = false;
        if(prev_jump-1>0){
            flag = dp(stones,map,pos+(prev_jump-1),prev_jump-1,end);
        }
        flag = flag||dp(stones,map,pos+prev_jump,prev_jump,end)
                    ||dp(stones,map,pos+prev_jump+1,prev_jump+1,end);
        map.put(key,flag);
        return flag;
    }
    public static void main(String[] args){
        System.out.println(canCross(new int[]{0,1,3,5,6,8,12,17}));
    }
}
