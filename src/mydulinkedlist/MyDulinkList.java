package mydulinkedlist;

/**
 * Created by hpx on 2018/2/9.
 */
public class MyDulinkList<T extends Comparable<T>> {
    private Node head;
    public Node getHead(){
        return this.head;
    }
    public void headInsert(T data){
        Node node = new Node(data);
        /**
         * 为了代码的简洁性
         * 将if{}else 改写为了if语句
         */
        /*if(null == this.head){
            this.head = node;
        }else{
            node.next = this.head;
            this.head.pre = node;
            this.head = node;
        }*/
        if(null != this.head){
            node.next = this.head;
            this.head.pre = node;
        }
        this.head = node;
    }

    public void tailInsert(T data){
        Node node = new Node(data);
        if(null == this.head){
            this.head = node;
        }else{
            Node p = this.head;
            while(null != p.next){
                p = p.next;
            }
            p.next = node;
            node.pre = p;
        }
    }
    public void midInsert(T data){
        Node node =  new Node(data);
        if(null == this.head){
            this.head = node;
            return;
        }
        if(this.head.data.compareTo(data) > 0){
            node.next = this.head;
            this.head.pre = node;
            this.head = node;
            return;
        }
        Node p = this.head;
        while(p.next != null && p.next.data.compareTo(data) < 0){
            p = p.next;
        }
       /* if(p.next == null){
            p.next = node;
            node.pre = p;
        }else{
            node.next = p.next;
            p.next.pre = node;
            p.next = node;
            node.pre = p;
        }*/
        /*if(p.next == null){
            p.next = node;
            node.pre = p;
        }else{
           node.next = p.next;
           node.pre = p;
           p.next.pre = node;
           p.next = node;
        }*/
        if(null != p.next){
            node.next = p.next;
           p.next.pre = node;
        }
          node.pre = p;
          p.next = node;
    }
    public void remove(T data){
        if(this.head == null){
            System.out.println("该链表为空！");
            return;
        }
        if(this.head.data.compareTo(data) == 0) {
            this.head = this.head.next;
            this.head .pre = null;
            return;
        }
        Node p = this.head;
        while(p.next != null && p.next.data.compareTo(data) != 0){
            p = p.next;
        }
        if(null == p.next){
            System.out.println("要删除的数不存在！");
            return;
        }
        if(p.next.next != null){
            p.next.next.pre = p;
            p.next = p.next.next;
        }else{
            p.next = p.next.next;
        }
    }
    public void print(){
        Node node = this.head;
        if(null == this.head){
            System.out.println("该链表为空");
         return;
        }
        while(node != null){
            System.out.print(node.data+"-->");
            node = node.next;
        }
        System.out.println("null");
    }
    public class Node<T extends Comparable<T>>{
        private T data;
        private Node next;
        private Node pre;
        public Node(T data){
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }
    }
}
