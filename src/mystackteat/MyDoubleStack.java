package mystackteat;

/**
 * 双向栈，定义一个双向栈的类 它包含三个属性  栈1 和 栈2 的栈顶指针  还有一个数据域 datas
 * Created by hpx on 2018/2/26.
 * 两栈共享空间的好处，开辟一定的存储空间，两个栈同时共享这个空间
 * 实现了绿色共享
 */
public class MyDoubleStack {
    private static final int DOUBLE_SIZE = 20;
   private int[] datas;
   private int top1;
   private int top2;

    /**
     * 默认初始栈 开辟长度为20 的一个一维数组
     */
   public MyDoubleStack(){
       this(DOUBLE_SIZE);
   }
   public MyDoubleStack(int size){
       this.top1 = -1;
       this.top2 = size;
       this.datas = new int[size];
   }

    /**
     * 进栈操作，首先判栈是否已满 条件：top1+1 == top2
     * 也就是说不能有某个元素即属于栈1又属于栈2
     * @param number
     * @param e
     */
   public void push(int number,int e){
       if(top1+1 == top2){
           System.out.println("该栈已满！");
           return;
       }
       if(number == 1){
           datas[++top1] = e;
       }else{
           datas[--top2] = e;
       }
   }
   public Integer pop(int number){
       if(number == 1){
           if(top1 == -1){
               System.out.println("该栈为空！");
               return null;
           }
           return datas[top1--];
       }else{
           if(top2 == datas.length){
               System.out.println("该栈为空！");
               return null;
           }
           return datas[top2++];
       }
   }
   public Integer peek(int number){
       if(number == 1){
           if(top1 == -1){
               System.out.println("该栈为空！");
               return null;
           }
           return datas[top1];
       }else{
           if(top2 == datas.length){
               System.out.println("该栈为空！");
               return null;
           }
           return datas[top2];
       }
   }
   public boolean isEmpty(int number){
       if(number == 1){
           if(top1 == -1){
               return true;
           }
           return false;
       }else{
           if(top2 == datas.length){
               return true;
           }
           return false;
       }
   }
   public void printf(){
       for (int i = 0; i <= top1; i++) {
           System.out.println(datas[i]);
       }
       for (int i = datas.length-1; i >= top2 ; i--) {
           System.out.println(datas[i]);
       }
   }
}
