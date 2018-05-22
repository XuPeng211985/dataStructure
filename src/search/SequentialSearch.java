package search;

/**
 * Created by hpx on 2018/3/7.
 * 简单的顺序查找 时间复杂度为O（n）
 */
public class SequentialSearch {
    public static int Sequential_Search(int[] a,int key){
        for (int i = 0; i < a.length ; i++) {
            if(a[i] == key){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {32,43,22,1,6};
        int key = Sequential_Search(arr,22);
        System.out.println(key);
    }
}
