package sort;
import java.util.Arrays;
/**
 * 时间复杂度：O（n平方） 特点，交换的次数比冒泡排序少了
 *
 * 简单选择排序改进版：在原始简单排序的基础上 定义一个下标位min记录最小数值的下标，
 *    从第一个数开始，逐个和后边的数作比较 最终选出最小的一个数 并记录它的下标
 *    最后如果下标位min不等于初始值i 则交换下标为min和i的数值
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {32,44,2,22,43,555,1};
        arr = selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
   /*public static int[] SelectSort(int[] arr){
       int min = 0;
       for (int i = 0; i < arr.length; i++) {
           min = i;
           for (int j = i+1; j < arr.length; j++) {
               if(arr[min] > arr[j]){
                   min = j;
               }
           }
           if(min != i){
               int temp = arr[min];
               arr[min] = arr[i];
               arr[i] = temp;
           }
       }
       return arr;
   }*/
   public static int[] selectSort(int[] arr){
       if(null == arr){
           return null;
       }
       int min = 0;
       for (int i = 0; i < arr.length-1; i++) {
           min = i;
           for (int j = i+1; j < arr.length; j++) {
               if(arr[min] > arr[j]){
                   min = j;
               }
           }
           if(min != i){
               int temp = arr[min];
               arr[min] = arr[i];
               arr[i] = temp;
           }
       }
       return arr;
   }
}
