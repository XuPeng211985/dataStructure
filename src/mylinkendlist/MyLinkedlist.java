package mylinkendlist;
/**
 * Created by xupeng on 2018/2/6.
 */
public class MyLinkedlist <T extends Comparable<T>>{
    public MyLinkedlist(Node head) {
        this.head = head;
    }
    public MyLinkedlist(){
        this.head = null;
    }
    public class Node<T extends Comparable<T>>{
         private Node next;
         private T data;
         public Node(T data){
             this.data = data;
         }
         public Node getNext(){
             return this.next;
         }
         public void setNext(Node next){
              this.next =  next;
         }
         public T getData(){
             return this.data;
         }
     }
     private Node head;
     private Node tail;
     public void headInsert(T data){
         Node node = new Node(data);
         if(this.head != null){
             node.next = this.head;
         }
         this.head = node;
         return;
     }
     /**
      * 由于tail属性的存在尾插法变得更简洁
        空时，将头指针和尾指针都指向node ，不为空时，只需将插入的指针挂在tail的尾部
         然后更新node为新的tail 指针
      */
     public void tailInsert(T data){
         Node node =  new Node(data);
         if(null == this.head){
             this.head = node;
         }else{
             this.tail.next = node;
         }
         this.tail = node;
     }
     public void midInsert(T data){
         Node node = new Node(data);
         if(null == this.head){
             this.head = node;
             return;
         }
         if(this.head.data.compareTo(node.data) > 0){
              node.next = this.head;
              this.head = node;
              return;
         }
         Node p = this.head;
         while(null != p.next && p.next.data.compareTo(node.data) < 0){
             p = p.next;
         }
         node.next = p.next;
         p.next = node;
     }

    /**
     * 链表的删除：1.如果节点是头指针 head下移一位
     *             2.如果节点在中间，p.next =  p.next.next;
     *             3.如果p.next.next = null: 直接将尾指针指向P
     * @param data
     */
     public void remove(T data){
         if(this.head == null){
             System.out.println("该链表为空！！");
             return;
         }
         if(this.head.data.compareTo(data) == 0){
             this.head = this.head.next;
             return;
         }
         Node p = this.head;
         while(null != p.next && (p.next.data.compareTo(data) != 0)){
             p = p.next;
         }
         if(p.next != null){
             if(p.next.next == null){
                 this.tail = p;
             }
             p.next = p.next.next;
         }else{
             System.out.println("没有要删除的值 ！");
         }
     }

    /**
     * 链表的逆制：定义一个临时头指针 然后遍历当前链表的每一个节点
     * 采用头插法插入到新的空指针尾部构成新的链表
     * 最后将head指向新的头指针
     */
    public void reversed(){
         Node newHead = null;
         Node p = this.head;
         while(p != null){
             this.head = this.head.next;
             p.next = newHead;
             newHead = p;
             p = this.head;
         }
         this.head = newHead;
     }

    /**
     * 链表的输出：遍历链表中的每个节点 输出节点所对应的数据
     * 判断链表是否有环，如果有环，则以node==this.tail结束遍历
     * 少输出尾节点，补充输出
     */
     public void print(){
         Node node = this.head;
         if(this.hasLoop()){
            while(node != null && node != this.tail){
                System.out.print(node.data+"-->");
                node = node.next;
            }
             System.out.println(this.tail.data+"-->null");
             return;
         }
         while(null != node){
             System.out.print(node.data+"-->");
             node = node.next;
         }
         System.out.println("null");
     }
    /**
     * 创建带环的链表 采用动态参数为函数入参
     * 采用任何一种方法进行插入操作
     * 每次插入之后将尾指针指向当前链表的头指针
     * @param datas
     */
     public void creatLoopLink(T ... datas){
         if(null == datas || datas.length == 0){
             return;
         }
         for(T data : datas){
             this.tailInsert(data);
         }
         this.tail.next = this.head;
     }
    /**
     * 判断链表中是否有环：
     *   同时定义两个临时指针分别指向当前链表的头结点
     *   进入while循环 一个指针一次跳一步 另一个指针一次跳两步
     *   如果慢指针和快指针某时刻指向了同一个节点，那么
     *   证明该链表有环
     *   其中while循环的结束条件是：快指针的下一个指向不能为空，并且慢指针
     *   的当前指向不能为空
     * @return
     */
     public boolean hasLoop(){
         Node slow = this.head;
         Node fast = this.head;
         while(null != slow && fast.next != null){
             slow = slow.next;
             fast = fast.next.next;
             if(slow == fast){
                 return true;
             }
         }
         return false;
     }
}
