import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Swathi on 8/22/2017.
 */
public class L347 {
    public static void main(String[] args){
        System.out.println(topKFrequent(new int[]{1,1,1,2,2,3},2));
    }
    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        //build frequency map
        Map<Integer,Integer> freq_map = new HashMap<>();
        for(int i : nums){
            freq_map.put(i,freq_map.getOrDefault(i,0)+1);
        }

        //bucket sort
        int[] bucket = new int[nums.length+1];
        for(int key: freq_map.keySet()){
            bucket[freq_map.get(key)]=key;
        }
        int count = 0;
        for(int i = bucket.length-1;i>=0;i--){
            if(bucket[i]!=0&&count<k){
                res.add(bucket[i]);
                count++;
            }
        }
        return res;
    }
}
