package mystack.rpn;

/**
 * Created by hpx on 2018/2/27.
 */
public class ReversePolishMain {
    public static void main(String[] args) {
        ReversePolish reversePolish = new ReversePolish();
        String result = reversePolish.reversePolish("9+(3-1)*3+4/2");
        //System.out.println(result);
       int a = Calculator.calculate(result);
       System.out.println(a);
    }
}
