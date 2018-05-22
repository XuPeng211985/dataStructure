package search;

/**
 * 改进后的顺序查找算法
 * 如果返回0则表示查找失败
 * Created by hpx on 2018/3/7.
 */
public class SequentialSearch1 {
    public static int Sequential_Search1(int[] arr,int key){
        int i = arr.length-1;
        arr[0] = key;//哨兵
        while(arr[i] != key){
            i--;
        }
        return i;
    }
    public static void main(String[] args) {
        int[] arr = {22,44,33,5,66,77};
       int key =  Sequential_Search1(arr,55);
        System.out.println(key);
    }
}
