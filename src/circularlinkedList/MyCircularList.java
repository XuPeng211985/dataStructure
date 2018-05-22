package circularlinkedList;

/**
 * 循环链表 特点 ： 头插和尾插相同
 * Created by xiaopeng on 2018/2/21.
 */
public class MyCircularList  <T extends Comparable<T>>{
    private Node head;
    public Node getTail(){
        Node tail = this.head;
        while(tail.next != this.head){
            tail = tail.next;
        }
        return tail;
    }
    public void headInsert(T data){
        Node node =  new Node(data);
        if(this.head == null){
            this.head = node;
            this.head.next = this.head;
            return;
        }
        Node tail = this.getTail();
        node.next = this.head;
        this.head = node;
        tail.next = this.head;
    }
    public void print(){
        if(this.head == null){
            System.out.println("该链表为空！");
            return;
        }
        System.out.print(this.head.data+"-->");
        Node node =  this.head.next;
        while(null != node && node != this.head){
            System.out.print(node.data+"-->");
            node = node.next;
        }
        if(node == this.head){
            System.out.print("head");
        }else{
            System.out.print("null");
        }
    }
    public void midInsert(T data){
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            this.head.next = this.head;
            return;
        }
        if(this.head.data.compareTo(data) > 0){
            Node tail = this.getTail();
            node.next = this.head;
            this.head = node;
            tail.next = this.head;
            return;
        }
        Node p = this.head;
        while(p.next != this.head && p.next.data.compareTo(data) <= 0){
            p = p.next;
        }
        if(this.head != p.next){
            node.next = p.next;
            p.next = node;
        }else{
            node.next = this.head;
            p.next = node;
        }
    }
    public void remove(T data){
       if(null == this.head){
           System.out.println("该链表为空！");
        return;
       }
       if(this.head.data == data){
           this.head = this.head.next;
           Node tail = this.getTail();
           tail.next = this.head;
           return;
       }
       Node p = this.head;
       while(p.next != this.head && p.next.data.compareTo(data) != 0){
           p = p.next;
       }
       if(p.next != this.head){
           p.next = p.next.next;
       }else{
           System.out.println("该数不存在");
       }
    }
    public class Node{
       private T data;
       private Node next;
       public Node (T data){
           this.data = data;
       }
    }
}
