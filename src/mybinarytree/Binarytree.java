package mybinarytree;
import java.util.Stack;
/**
 * Created by xp on 2018/3/5.
 */
public class Binarytree {
    private Node root;
    private int index;
    public Node getRoot(){
        return this.root;
    }
    public  Node init(String source){
        if(this.index >= source.length()){
            return null;
        }
        char data = source.charAt(index++);
        if(data == '#'){
            return null;
        }
        Node node = new Node(data);
        node.lchild = init(source);
        node.rchild = init(source);
        return node;
    }
    public void inorder(Node node){
        if(null == node){
            return;
        }
        inorder(node.lchild);
        System.out.print(node.data+"-->");
        inorder(node.rchild);
    }
    public void preorder(Node node){
        if(null == node){
            return ;
        }
        System.out.print(node.data+"-->");
        preorder(node.lchild);
        preorder(node.rchild);
    }
    public void postorder(Node node){
        if(null == node){
            return;
        }
        postorder(node.lchild);
        postorder(node.rchild);
        System.out.print(node.data+"-->");
    }

    /**
     * 非递归先序遍历二叉树：
     * 从根节点开始遍历二叉树，首先根节点入栈 输出根节点的数据
     * 接着遍历根节点的左子树的根节点并且输出对应数据
     * 直到遍历完左子树根节点的所有左孩子
     * 然后依次退栈 并且遍历这些根节点的右孩子，如果右孩子的存在 则再次进入
     * 第二个while循环.....
     *
     * @param node
     */
    public void Non_Recursion_preOrder(Node node){
        Stack<Node> stack =  new Stack<>();
        while(null != node || !stack.isEmpty()){
            while(null != node){
                System.out.print(node.data+" ");
                stack.push(node);
                node = node.lchild;
            }
            if(!stack.isEmpty()){
                node = stack.pop();
                node = node.rchild;
            }
        }
    }

    /**
     * 中序遍历二叉树:
     * 中序遍历和先序遍历代码结构一样只是从左孩子节点开始输出
     * @param node
     */
    public void Non_Recursion_Inorder(Node node){
        Stack<Node> stack = new Stack<>();
        while(null != node || !stack.isEmpty()){
            while(null != node) {
                stack.push(node);
                node = node.lchild;
            }
            if(!stack.isEmpty()){
                node = stack.pop();
                /**
                 * 刚开始栈里面除了根节点都存储着相对各自父节点的左孩子
                    则输出时 首先输出的是左孩子节点
                 */
                System.out.print(node.data + " ");
                node = node.rchild;
            }
        }
    }

    /**
     * 后序非递归实现思路：
     * 根节点入栈（后序遍历根节点一定在栈低，最后一个出栈）
     * 定义两个临时节点，cur 指向栈顶节点  pre 指向上次出栈的节点
     * 总循环结构以栈空为结束条件 ，循环体中 cur指向栈顶元素 判断cur是否为叶子节点 或者pre是否
     * 为cur的孩子节点 满足两个条件中的一个 则栈顶元素出栈，并输出栈顶元素的数据
     * 反之则cur的右孩子不为空 则将右孩子入栈 cur的左孩子不为空 则将左孩子入栈
     * （这里必须要先判断右孩子再判断左孩子，这样出栈时左孩子就可以在右孩子的前面）
     * @param node
     */
    public void Non_Recursion_Postorder(Node node){
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        Node pre = null;
        Node cur = node;
        while(! stack.isEmpty()){
            cur = stack.peek();
            if(validate(cur,pre)){
                System.out.print(cur.data + "");
                stack.pop();
                pre = cur;
            }else{
                if(cur.rchild != null){
                    stack.push(cur.rchild);
                }
                if(cur.lchild != null){
                    stack.push(cur.lchild);
                }
            }
        }

    }
    public void InThreading(){
        InThreading(this.root,null);
    }
    public void InThreading(Node node,Node pre){
         if(null == node){
             return;
         }
         InThreading(node.lchild,pre);
         if(null == node.lchild){
             node.ltag = true;
             node.lchild = pre;
         }
         if(null != pre && null == pre.rchild){
             pre.rtag = true;
             pre.rchild = node;
         }
         InThreading(node.rchild,node);
    }
    public boolean validate(Node cur,Node pre){
        if(null == cur.lchild && null == cur.rchild){
            return true;
        }
        if(null != pre && (pre == cur.lchild || pre == cur.rchild)){
            return true;
        }
        return false;
    }
    public class Node{
        private char data;
        private Node lchild;
        private Node rchild;
        private boolean ltag;
        private boolean rtag;
        public Node(char ch){
            this.data = ch;
        }

        public char getData() {
            return data;
        }

        public void setData(char data) {
            this.data = data;
        }

        public Node getLchild() {
            return lchild;
        }

        public void setLchild(Node lchild) {
            this.lchild = lchild;
        }

        public Node getRchild() {
            return rchild;
        }

        public void setRchild(Node rchild) {
            this.rchild = rchild;
        }
    }
}
