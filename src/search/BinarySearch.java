package search;

/**二分查找:  算法复杂度为 Olog(n)
 * 定义两个临时指针 一个指向第一个数字，另一个指向最后一个数字
 * 以low > high 为结束循环的条件 每次让key值与中间数作比较
 * 如果小了 则将查找范围缩小为左半部分，更新high值为mid-1
 * 如果大了 则将查找范围缩小为右半部分，更新low值为mid+1
 * Created by hpx on 2018/3/7.
 */
public class BinarySearch {
    public static int Binary_Search(int[] arr,int key){
        int low = 1;
        int high = arr.length-1;
        int mid = 0;
        while(low <= high){
            mid = (high+low)/2;
            if(key > arr[mid]){
                low = mid+1;
            }else if(key < arr[mid]){
                high =  mid-1;
            }else{
                return mid;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] arr = {0,1,16,24,35,47,59,62,73,88,99};
        int key = Binary_Search(arr,62);
        System.out.println(key);
    }
}
