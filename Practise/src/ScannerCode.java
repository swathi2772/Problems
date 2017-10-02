import java.util.Scanner;

/**
 * Created by Swathi on 8/30/2017.
 */
public class ScannerCode {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter your rollno");
        int rollno=sc.nextInt();
        System.out.println("Enter your name");
        String name=sc.next();
        System.out.println("Enter your1" +
                " fee");
        double fee=sc.nextDouble();
        System.out.println("Rollno:"+rollno+" name:"+name+" fee:"+fee);
        sc.close();
    }
}
