package myqueue;

/**
 * 循环队列：解决“公交车前排有座 后排已满的 假溢出现象”
 * 插入一个元素队尾加1 对头不变 删除一个元素队头加1 队尾不变
 * 直到对头序号和队尾序号相差1 或 相差一圈是 表示队满
 * Created by hpx on 2018/3/1.
 */
public class MySeQueue {
    private Integer front;
    private Integer rear;
    public static int MAXSIZE = 8;
    private Integer size;
    private int datas[];
    public MySeQueue(){
        this(MAXSIZE);
    }
    public MySeQueue(int size){
        this.front = 0;//对头
        this.rear = 0;//队尾
        this.datas = new int[size];
    }
    /**
     * 判队列满的条件： （rear+1）%MAXSIZE == front
     * 虽然队头和队尾相差一个位置就代表队列满 但是也有可能是刚好相差一圈
     * @param data
     */
    public void EnQueue(int data){
        if((this.rear+1) % (MAXSIZE) == this.front){
            System.out.println(" 该队列已满！");
        }else{
            this.datas[this.rear] = data;
            this.rear = (this.rear+1) % MAXSIZE;
        }
    }
    public int DeQueue(){
        int data = 0;
        if(this.rear == this.front){
            System.out.println("队列为空！");
        }else {
            data = this.datas[this.front+1];
            this.front = (this.front+1)%MAXSIZE;
        }
        return data;
    }
    public void print(){
        while(this.front != this.rear){
            System.out.print(this.datas[this.front]+" ");
            this.front = (this.front+1)%MAXSIZE;
        }
    }

}
