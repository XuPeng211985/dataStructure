import java.util.Scanner;
/**
 * Created by hpx on 2018/3/23.
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int ch = sc.nextInt();
        int min = 0;
        int count = 0;
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length ; i++) {
            for (int j = i+1; j < arr.length ; j++) {
                if(arr[i] == arr[j]){

                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if((arr[i] - arr[j]) == ch || (arr[i] - arr[j]) == -ch){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
