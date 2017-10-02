package Snap;

/**
 * Created by Swathi on 9/22/2017.
 */
public class BigInteger {
    private String val;

    public BigInteger(String val) {
        this.val = val;
    }



    public static void main(String[] args){
        BigInteger a = new BigInteger("9991");
        BigInteger b = new BigInteger("99921");
        System.out.println(a.add(b).val.toString());
    }

    private BigInteger add(BigInteger o) {
        StringBuilder sb = new StringBuilder();
        int len_a = this.val.length();
        int len_b = o.getVal().length();
        String a, b;
        if(len_a<len_b){
            a = pad(this.getVal(),len_b-len_a);
            b = o.getVal();
        }else if(len_a>len_b){
            a = this.getVal();
            b = pad(o.getVal(),len_a-len_b);
        }else {
            a = this.getVal();
            b = o.getVal();
        }

        int carry = 0;
        for(int i=a.length()-1;i>=0;i--){
            int ch = a.charAt(i)- 48+ b.charAt(i) -48+carry;
            if(ch>=10){
                carry = ch/10;
                ch = ch%10;
            }else{
                carry = 0;
            }
            sb.insert(0,ch);

        }
        if(carry==0){
            return new BigInteger(sb.toString());
        }
        return new BigInteger(sb.insert(0,carry).toString());
    }

    private String pad(String val, int len) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len;i++){
            sb.append(0);
        }
        return sb.append(val).toString();
    }

    public String getVal() {
        return val;
    }
}
