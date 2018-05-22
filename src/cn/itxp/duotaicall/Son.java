package cn.itxp.duotaicall;

/**
 * Created by hpx on 2018/4/10.
 */
public class Son extends Father {

    @Override
    public void fun() {
        System.out.println("son-fun");
    }
    //子类特有的方法
    public void fun1(char a) {
        System.out.println("son-s1 para-char"+a);
    }
}
