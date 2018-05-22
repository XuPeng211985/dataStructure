package sort;

/**
 * Created by hpx on 2017/9/20.
 */
public class QuickSort<T> {
   public int partition(int low,int high,int[] arr){
        int temp = 0;
        int  key = arr[low];
        while (low < high){
            while(low < high && key < arr[high]){
                high--;
            }
        if(arr[low] != arr[high]) {
            temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
        }
            while(low < high && key > arr[low]){
                low++;
            }
            if(arr[low] != arr[high]){
                temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
        }
       return low;
    }
    public  void sort(int[] arr,int low,int high){
        if(low >= high){
            return;
        }
        int mid =this.partition(low,high,arr);
        sort(arr,low,mid-1);
        sort(arr,mid+1,high);
    }

   /*private static <E extends Comparable<E>> int partition(List<E> list, int low, int high){
       E key = list.get(low);
       while(low < high){
           while(low < high && key.compareTo(list.get(high)) < 0){
               --high;
           }
           list.set(low, list.get(high));
           while(low < high && key.compareTo(list.get(low)) > 0){
                         ++low;
                        }
               list.set(high, list.get(low));
                 }
        list.set(low, key);
         return low;
       }
    private static <E> void sort(List<E> list, int low, int high, Comparable<E> compare){
            if(low >= high){
                      return;
                  }
           // int midde = partition(list, low, high, compare);
             sort(list, low, midde - 1, compare);
            sort(list, midde + 1, high, compare);
     }*/


    public static void main(String[] args) {
        int[] datas = new int[]{
                5,1,3,7,4,2,6,8,9
        };
        QuickSort quickSort = new QuickSort();
        quickSort.sort(datas,0,datas.length-1);
        for(int data : datas){
            System.out.print(data+"\t");
        }
        System.out.println();
    }
}