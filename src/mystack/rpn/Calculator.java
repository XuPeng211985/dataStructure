package mystack.rpn;

import java.util.Stack;

/**
 * Created by hpx on 2018/2/27.
 */
public class Calculator {
    public static int calculate(String reverse){
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < reverse.length(); i++) {
            char ch = reverse.charAt(i);
            if(ReversePolishUtils.isNumber(ch)){
                //将基本数据类型转换成 String 的 static 方法  String.valueOf()
                stack.push(Integer.valueOf(String.valueOf(ch)));
                continue;
            }
            int operand = stack.pop();
            int lastoperand = stack.pop();
            stack.push(ReversePolishUtils.calculate(operand,lastoperand,ch));
        }
        int result =  stack.pop();
        return result;
    }
}
