package myarraylist;

import java.util.Arrays;

/**
 * Created by hpx on 2018/2/6.
 */
public class ArrayAddMain {
    public static void main(String[] args) {
        int[] arr1 = {1,2,6,9,10};
        int[] arr2 = {3,4,5,7,8};
        int[] arr3 =  ArrayAdd.add(arr1,arr2);
        System.out.println(Arrays.toString(arr3));
    }
}
