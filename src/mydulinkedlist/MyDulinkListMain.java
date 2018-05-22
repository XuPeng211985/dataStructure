package mydulinkedlist;
/**
 * Created by hpx on 2018/2/11.
 */
public class MyDulinkListMain {
    public static void main(String[] args) {
        MyDulinkList<Integer> myDulinkList = new MyDulinkList<>();
       /* myDulinkList.headInsert(1);
        myDulinkList.headInsert(5);
        myDulinkList.headInsert(3);
        myDulinkList.headInsert(6);
        myDulinkList.headInsert(4);*/
       /* myDulinkList.tailInsert(1);
        myDulinkList.tailInsert(5);
        myDulinkList.tailInsert(3);
        myDulinkList.tailInsert(6);
        myDulinkList.tailInsert(4);
        Integer integer = (Integer) myDulinkList.getHead().getNext().getNext().getPre().getData();
        System.out.println(integer);*/
       myDulinkList.midInsert(1);
        myDulinkList.midInsert(6);
        myDulinkList.midInsert(4);
        myDulinkList.midInsert(5);
        myDulinkList.midInsert(3);
        myDulinkList.midInsert(2);
        myDulinkList.remove(6);
        myDulinkList.print();
    }
}
