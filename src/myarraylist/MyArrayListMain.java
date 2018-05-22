package myarraylist;

/**
 * Created by hpx on 2018/2/6.
 */
public class MyArrayListMain {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList(6);
        myArrayList.insert(4);
        myArrayList.insert(5);
        myArrayList.insert(1);
        myArrayList.insert(3);
        myArrayList.insert(6);
        myArrayList.insert(2);
        myArrayList.remove(8);
        myArrayList.print();
    }
}
