import java.util.Scanner;
/**
 * Created by hpx on 2018/3/23.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in = sc.nextInt();
        String[] s = new String[in];
        for(int i = 0; i < in; i++){
           s[i] = sc.next();
        }
        for (int i = 0; i < in; i++) {
            if(s[i].equals("6+6")){
                System.out.println(".....6..66666");
                System.out.println(".....6......6");
                System.out.println(".....6..66666");
                System.out.println(".....6..6....");
                System.out.println(".....6..66666");
             }
             if(s[i].equals("6*6")){
                 System.out.println("66666..66666");
                 System.out.println("....6..6....");
                 System.out.println("66666..66666");
                 System.out.println("....6..6...6");
                 System.out.println("66666..66666");
             }
            }
        }
    }
