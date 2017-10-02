import java.util.ArrayList;
import java.util.List;

/**
 * Created by Swathi on 8/16/2017.
 */
public class L1181 {
    public static void  main(String[] args){
        System.out.println(generate(5));
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        res.add(row);
        int count =1;
        while(count<numRows){
            List<Integer> tmp = new ArrayList<>();
            for(int i=0;i<=count;i++){
                if(i==0||i==count){
                    tmp.add(i,1);
                }else {
                    tmp.add(i,res.get(count-1).get(i)+res.get(count-1).get(i-1));
                }
            }
            res.add(tmp);
            count++;
        }
        return res;
    }
}
