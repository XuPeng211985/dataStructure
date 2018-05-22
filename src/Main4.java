import java.util.Scanner;

/**
 * Created by hpx on 2018/3/26.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nanduArr = new int[n];
        int[] baochouArr = new int[n];
        int[] nengliArr = new int[m];
        for (int i = 0; i < n; i++) {
            nanduArr[i] = sc.nextInt();
            baochouArr[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            nengliArr[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                if(nengliArr[i] <= nanduArr[j] &&baochouArr[j] > max ){
                        max = baochouArr[j];
                }
            }
            System.out.println(max);
        }
    }
}
