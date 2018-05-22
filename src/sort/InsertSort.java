package sort;

import java.util.Arrays;

/**
 * 插入排序： 将原序列分为两部分 有序的一部分和无序的一部分
 *      初始状态有序部分为第一个元素 剩下的大半部分是无序的
 *      逐个遍历无序的子序列，将它里面的元素逐个插入到有序的序列中
 *      每插入一个 有序的序列长度加1 无序的长度减1
 *      最终将整个序列都变为有序的
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {44,33,3,54,2,22,66};
        arr = insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /*public static int[] InsertSort(int[] arr){
       int temp = 0;
       int j = 0;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            for (j = i; j > 0 && arr[j-1] > temp; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
        return arr;
    }*/
    public static int[] insertSort(int[] arr){
        int temp = 0;
        int j = 0;
        if(null == arr){
            return null;
        }
        for (int i = 1; i < arr.length; i++) {
           temp = arr[i];
           for(j = i; j > 0 && arr[j-1] > temp; j--){
               arr[j] = arr[j-1];
           }
           arr[j] = temp;
        }
        return arr;
    }
}
