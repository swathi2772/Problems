import java.util.*;

/**
 * Created by Swathi on 9/5/2017.
 */
public class L380 {
    public static void main(String[] args){
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(-1);
        boolean param_2 = obj.remove(-2);
        boolean param_3 = obj.insert(-2);
        int param_4 = obj.getRandom();
        boolean param_5 = obj.remove(-1);
        boolean param_6 = obj.insert(-2);
        int param_7 = obj.getRandom();
        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
        System.out.println(param_5);
        System.out.println(param_6);
        System.out.println(param_7);
    }

}
class RandomizedSet {
    List<Integer> list;
    Map<Integer,Integer> map;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        list.remove(map.get(val));
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */