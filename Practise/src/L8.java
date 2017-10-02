/**
 * Created by Swathi on 8/14/2017.
 */
public class L8 {
    public static void main(String[] args){
        System.out.println(myAtoi("9223372036854775809"));
    }
    public static int myAtoi(String str) {
        str = str.trim();
        long mult = 1;
        long ans = 0;
        if(str.length()==0){
            return 0;
        }
        for(int i=str.length()-1;i>=0;i--){
            char ch = str.charAt(i);
            if(i==0&&(ch=='-'||ch=='+')){
                ans = ch=='-'?-ans:ans;
            }else if(ch >47&&ch<58){
                ans = ans + mult*(ch-48);
                mult= mult*10;
            }else{
                ans = 0;
                mult = 1;
            }

        }
        if(ans>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(ans<(-Integer.MAX_VALUE-1)){
            return -Integer.MAX_VALUE-1;
        }
        return (int)ans;
    }
}
