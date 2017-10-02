/**
 * Created by Swathi on 8/15/2017.
 */
public class L38 {
    public static void main(String[] args){
        System.out.println(countAndSay(4));
    }
    public static String countAndSay(int n) {

        String res = "1";
        if(n==1){
            return res;
        }
        for(int i=1;i<n;i++){
            res = bla(res);
        }
        return res;
    }

    private static String bla(String s){
        String res = "";
        char prev = s.charAt(0);
        int count = 1;
        for(int i =1 ; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch==prev){
                count++;
            }else{
                res = res+count+""+prev;
                prev = ch;
                count = 1;
            }
        }
        res = res+count+""+prev;
        return res;

    }
}
