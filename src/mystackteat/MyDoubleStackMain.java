package mystackteat;

/**
 * Created by hpx on 2018/2/26.
 */
public class MyDoubleStackMain {
    public static void main(String[] args) {
        MyDoubleStack myDoubleStack = new MyDoubleStack(6);
        myDoubleStack.push(1,3);
        myDoubleStack.push(1,2);
        myDoubleStack.push(2,1);
        myDoubleStack.push(2,4);
        myDoubleStack.push(1,5);
       myDoubleStack.pop(1);
       myDoubleStack.pop(2);
       myDoubleStack.pop(1);
       int top1 = myDoubleStack.peek(1);
       int top2 = myDoubleStack.peek(2);
        System.out.println(top1);
        System.out.println(top2);
        myDoubleStack.printf();
    }
}
