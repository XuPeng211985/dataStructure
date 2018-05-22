package myqueue;

/**
 * Created by hpx on 2018/3/1.
 */
public class MySeQueueMain {
    public static void main(String[] args) {
        MySeQueue mySeQueue = new MySeQueue();
        mySeQueue.EnQueue(1);
        mySeQueue.EnQueue(3);
        mySeQueue.EnQueue(5);
        mySeQueue.EnQueue(6);
        mySeQueue.DeQueue();
        mySeQueue.DeQueue();
        mySeQueue.EnQueue(7);
        mySeQueue.print();
    }
}
