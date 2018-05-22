package mylinkendlist;

/**
 * Created by hpx on 2018/2/8.
 */
public class MyLinkedlistMain {
    public static void main(String[] args) {
        MyLinkedlist<String> myLinkedlist = new MyLinkedlist<>();
      /*  myLinkedlist.headInsert("a");
        myLinkedlist.headInsert("c");
        myLinkedlist.headInsert("f");
        myLinkedlist.headInsert("b");
        myLinkedlist.headInsert("e");*/
       /* myLinkedlist.midInsert("a");
        myLinkedlist.midInsert("c");
        myLinkedlist.midInsert("f");
        myLinkedlist.midInsert("b");
        myLinkedlist.midInsert("e");
        myLinkedlist.midInsert("d");*/
       /*myLinkedlist.tailInsert("a");
        myLinkedlist.tailInsert("c");
        myLinkedlist.tailInsert("f");
        myLinkedlist.tailInsert("b");
        myLinkedlist.tailInsert("e");
        myLinkedlist.tailInsert("d");
       // myLinkedlist.remove("d");
        myLinkedlist.reversed();*/

       myLinkedlist.headInsert("s");
        myLinkedlist.headInsert("d");
        myLinkedlist.headInsert("g");
        myLinkedlist.headInsert("h");
        myLinkedlist.headInsert("a");
        myLinkedlist.print();
        myLinkedlist.reversed();
        myLinkedlist.print();

    }
}
