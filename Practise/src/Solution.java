import java.io.*;
import java.util.*;
import java.util.stream.*;
//expected graduation date: Dec 2017
//looking for full time positions
class Solution {


    public static List<List<Integer>> groupByNumberOfParents(List<List<Integer>> parentChildPairs) {
        // IMPLEMENTATION GOES HERE
        Map<Integer,Integer> map = new HashMap<>();
        for(List<Integer> list: parentChildPairs){
            if(list.size()!=2){
                continue;
            }
            int parent = list.get(0);
            int child = list.get(1);
            if(!map.containsKey(parent)){
                map.put(parent,0);
            }
            if(map.containsKey(child)){
                int val = map.get(child);
                map.put(child,++val);
            }else{
                map.put(child,1);
            }
        }
        Map<Integer,List<Integer>> res_map = new HashMap<>();
        int last_key=-1;
        for(int key: map.keySet()){
            int value =map.get(key);
            if(last_key<value)last_key = value;
            if(!res_map.containsKey(value)){
                List<Integer> l = new ArrayList<>();
                res_map.put(value,l);
                l.add(key);
            }else{
                List<Integer> l = res_map.get(value);
                l.add(key);
            }

        }
        List<List<Integer>> temp = new ArrayList<>();
        for(int i=0;i<=last_key;i++){
            if(res_map.containsKey(i)){
                temp.add(res_map.get(i));
            }else {
                temp.add(new ArrayList<>());
            }
        }
        return temp;
    }

  /* START TEST CASES
   * You can add test cases below. Each test case input/expected output
   * should correspond to the same index in the respective lists returned.
   */

    static List<List<List<Integer>>> testInputs = Arrays.asList(
            Arrays.asList(
                    Arrays.asList(1, 3),
                    Arrays.asList(2, 3),
                    Arrays.asList(3, 6),
                    Arrays.asList(5, 6),
                    Arrays.asList(5, 7),
                    Arrays.asList(4, 5),
                    Arrays.asList(4, 8),
                    Arrays.asList(8, 9)
            ),
            Arrays.asList(
                    Arrays.asList(1, 3),
                    Arrays.asList(2, 3)
            )
    );

    static List<List<List<Integer>>> testOutputs = Arrays.asList(
            Arrays.asList(
                    Arrays.asList(1, 2, 4),
                    Arrays.asList(5, 7, 8, 9),
                    Arrays.asList(3, 6)
            ),
            Arrays.asList(
                    Arrays.asList(1, 2),
                    Arrays.asList(),
                    Arrays.asList(3)
            )
    );

  /* END TEST CASES */

    // DO NOT MODIFY BELOW THIS LINE

    public static boolean equalOutputs(List<List<Integer>> a, List<List<Integer>> b) {
        if (a.size() != b.size()) {
            return false;
        }
        for (int i = 0; i < a.size(); i++) {
            List<Integer> a1 = a.get(i);
            List<Integer> b1 = b.get(i);
            a1.sort(null);
            b1.sort(null);
            if (!a1.equals(b1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < testInputs.size(); i++) {
            List<List<Integer>> expectedOutput = testOutputs.get(i);
            List<List<Integer>> actualOutput = groupByNumberOfParents(testInputs.get(i));
            if (equalOutputs(expectedOutput, actualOutput)) {
                System.out.println("Pass");
            } else {
                System.out.println("Fail");
            }
        }
    }
}
