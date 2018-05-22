import java.util.Scanner;

/**
 * Created by hpx on 2018/3/26.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        int j = k;
        for (int i = k; i <= n; i++) {
                if(i%j >= k){
                    count++;
                }
                if(j <= n){
                    j++;
                }
        }
        System.out.println(count);
    }
}
