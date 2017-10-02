import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Swathi on 8/17/2017.
 */
public class L140 {

    public static void main(String[] args){
        System.out.println(wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
    }
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        backtrack(s,"",res,s,wordDict);
        return res;

    }

    public static void backtrack(String initial,String prev,List<String> res, String s, List<String> wordDict){

        String tmp = prev.replace(" ","");
        if(tmp.equals(initial)){
            res.add(prev.trim());
        }else{

            int start = 0;
            for(int i=0;i<=s.length();i++){
                String word  = s.substring(start,i);
                if(wordDict.contains(word)){
                    backtrack(initial,prev+word+" ",res,s.substring(i),wordDict);
                }
            }
        }
    }
}
