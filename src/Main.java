import java.util.Scanner;

/**
 * Created by hpx on 2018/3/23.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int n = sc.nextInt();
        if(n % 2 == 0){
            while(n != 2){
                count = count+2;
                n = n/2;
            }
        }
        System.out.println(count);
    }
}
