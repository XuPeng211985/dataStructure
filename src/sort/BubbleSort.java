package sort;
import java.util.Arrays;
/**时间复杂度：O（n平方）
 * 冒泡排序改进版: 外层for 循环趟数 内层for交换趟数
 *    定义一个“眼位” 如果当前两个数已经有序了，那就将眼位设置为true
 *    当第二趟循环时如果一个位置都不变则flag永远是flase 外层for循环直接退出
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2,1,3,32,44,55,56,4444};
        arr = BubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
   /* public static int[] BubbleSort(int[] arr){
        boolean flag = true;
        for (int i = 0; i < arr.length-1 && flag ; i++) {
            flag = false;
            for(int j = arr.length-2; j >= i; j--){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
        }
        return arr;
    }*/
   public static int[]  BubbleSort(int[] arr){
       if(null == arr){
           return null;
       }
       boolean flag = true;
       for(int i = 0; i < arr.length-1 && flag; i++){
           flag = false;
           for (int j = arr.length-1; j > i ; j--) {
               if(arr[j] < arr[j-1]){
                   int temp = arr[j];
                   arr[j] = arr[j-1];
                   arr[j-1] = temp;
                   flag = true;
               }
           }
       }
       return arr;
    }
}
