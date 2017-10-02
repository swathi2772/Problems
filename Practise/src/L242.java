/**
 * Created by Swathi on 8/21/2017.
 */
public class L242 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int c = '0';
        for(int i=0;i<s.length();i++){
            c = c^s.charAt(i)^t.charAt(i);
        }
        return c=='0';
    }
}
