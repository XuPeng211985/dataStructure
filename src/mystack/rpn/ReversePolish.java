package mystack.rpn;
import java.util.Stack;

/**
 * Created by hpx on 2018/2/27.
 * 中缀表达式转为后缀表达式 ：
 *    第一步：判断优先级 getPriority
 *    第二步：判断当前字符是否为数字 ，数字直接保存 符号分三种--》左括号 右括号 优先级 讨论
 */
public class ReversePolish {
    public static Integer getPriority(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        }
        if (ch == '*' || ch == '/') {
            return 2;
        }
        return null;
    }

    public String reversePolish(String reverse) {
        Stack<Character> stack = new Stack<>();
        StringBuffer list = new StringBuffer();
        for (int i = 0; i < reverse.length(); i++) {
            char ch = reverse.charAt(i);
            if (ReversePolishUtils.isNumber(ch)) {
                //如果是数字，直接添加到StringBuffer中
                list.append(ch);
            } else {
                //字符 包括 + - * / ( ) 刚开始的第一个字符不可能是右括号
                //则栈为空 或者 左括号 直接压栈
                if (stack.isEmpty() || ch == '(') {
                    stack.push(ch);
                    continue;
                }
                //由于‘||’的短路现象 isEmpty成立 后面的语句将不再执行
                //则需要重新判断字符是否为左括号
                if (stack.peek() == '(') {
                    stack.push(ch);
                    continue;
                }
                //遇到右括号 则需要遍历栈 ，不断出栈 寻找左括号 直到栈顶元素为左括号 停止
                if (ch == ')') {
                    while (stack.peek() != '(') {
                        list.append(stack.pop());
                    }
                    stack.pop();
                    continue;
                }
                //如果当前字符的优先级小于栈顶字符的优先级 则栈顶元素出栈
                //出栈后如果栈顶字符的优先级最低 则依然将该栈顶元素出栈
                //反之则将该当前字符压栈
                if (getPriority(ch) < getPriority(stack.peek())) {
                    list.append(stack.pop());
                    if(getPriority(stack.peek()) == 1){
                        list.append(stack.pop());
                    }else {
                        stack.push(ch);
                        continue;
                    }
                }
                stack.push(ch);
            }
        }
        //将字符串遍历完之后 将栈内的所有元素出栈 追加当StringBuffer中
        while(!stack.isEmpty()){
            list.append(stack.pop());
        }
        String reverse1 = list.toString();
        return reverse1;
    }

}

