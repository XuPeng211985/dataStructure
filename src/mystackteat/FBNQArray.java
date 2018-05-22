package mystackteat;

/**
 * 递归的应用 斐波那契数列
 * 递归的关键是一定要找到正确返回的条件 然后理解递归的条件
 * Created by hpx on 2018/2/26.
 */
public class FBNQArray {
    public static int FBNQ(int i){
        if(i < 2){
            return i == 1 ? 1 : 0;
        }
        return FBNQ(i-1)+FBNQ(i-2);
    }
    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.print(FBNQ(i)+"-->");
        }
        System.out.println(FBNQ(30));
    }
}
