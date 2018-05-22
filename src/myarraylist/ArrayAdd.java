package myarraylist;

/**
 * Created by xiaopeng on 2018/2/6.
 * 关于两个有序数组的合并，
 * 基本思想为 第一个while循环以两个数组都没有遍历完为继续执行的条件，相同位置的元素 哪个数组的小 则先把哪个元素传给新数组
 * 这个循环退出后，若两个数组长度不相等，则更长的那个数组还没有遍历完，直接将剩余的数字都传给合并后的数组
 */
public class ArrayAdd {
    public static int[] add(int[] arr1,int[] arr2){
        int[] arr3 = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
               arr3[k++] = arr1[i++];
            }else{
                arr3[k++] = arr2[j++];
            }
        }
        while(i < arr1.length){
            arr3[k++] = arr1[i++];
        }
        while(j < arr2.length){
            arr3[k++] = arr2[j++];
        }
        return arr3;
    }
}
