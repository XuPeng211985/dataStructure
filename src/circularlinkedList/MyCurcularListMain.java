package circularlinkedList;

/**
 * Created by hpx on 2018/2/21.
 */
public class MyCurcularListMain {
    public static void main(String[] args) {
        MyCircularList<String> circularList = new MyCircularList<>();
       /* circularList.headInsert("123");
        circularList.headInsert("321");
        circularList.headInsert("abc");
        circularList.headInsert("cba");
        circularList.headInsert("def");
        circularList.headInsert("ghj");*/
       circularList.midInsert("b");
        circularList.midInsert("f");
        circularList.midInsert("a");
        circularList.midInsert("e");
        circularList.midInsert("d");
        circularList.remove("f");
        circularList.print();
    }
}
