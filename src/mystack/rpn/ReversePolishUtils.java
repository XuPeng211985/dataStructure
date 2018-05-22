package mystack.rpn;

/**
 * 工具类主要包括两个静态方法 判断是否为数字   和   两个字符的四则运算
 * Created by hpx on 2018/2/27.
 */
public class ReversePolishUtils {
    public static boolean isNumber(char ch){
        if(ch >= '0' && ch <= '9'){
            return true;
        }
        return false;
    }
    public static int calculate(int a,int b,char ch){
        if(ch == '+'){
            return a + b;
        }
        if(ch == '-'){
            return b - a;
        }
        if(ch == '*'){
            return a * b;
        }
        if(ch == '/'){
            return b/a;
        }
        return 0;
    }
}
