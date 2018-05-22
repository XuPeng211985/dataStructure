package myarraylist;
/**
 * Created by xiaopeng on 2018/2/6.
 * 1.初始化数组
 * 2.插入时 引入了临时变量temp 初始值设为this.size 用来记录要插入位置在数组中的序号
 *    首先将size-》temp的值均向后移一位 然后将值插入到 temp 的位置
 * 3.删除时，同样引入了临时变量location 初始值设为-1 location--》size的值均向前移一位
 */
public class MyArrayList {
    private int[] arr;
    private int size;
    public MyArrayList(int length){
        arr = new int[length];
        size = 0;
    }
    public void insert(int x){
        if(this.size > arr.length){
            System.out.println("数组存储空间已满，无法插入");
            return;
        }
        int temp = this.size;
        for (int i = 0; i < this.size ; i++) {
            if(arr[i] > x){
                temp = i;
                break;
            }
        }
        for(int i = this.size; i > temp; i--){
            arr[i] = arr[i-1];
        }
        arr[temp] = x;
        this.size++;
    }
    public int remove(int temp){
        if(this.size <= 0){
            System.out.println("该数组为空！");
            return -1;
        }
        int location = -1;
        for (int i = 0; i < this.size ; i++) {
            if(arr[i] == temp){
                location = i;
                break;
            }
        }
        if(location == -1){
            System.out.println("删除的数不存在！");
            return -1;
        }
        for (int i = location; i < this.size-1; i++) {
            arr[i] = arr[i+1];
        }
        this.size--;
        return temp;
    }
    public void print(){
        for (int i = 0; i < this.size ; i++) {
            System.out.print(arr[i]+"\t");
        }
    }
}
