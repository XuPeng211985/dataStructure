package search;
/**
 * Created by xp on 2018/3/7.
 */
public class SearchBST {
    /**
     * 内部类Node节点的结构
     */
    private Node root;
    public class Node{
        private int data;
        private Node lchild;
        private Node rchild;
        public Node(int data){
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
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
    /**
     * 定义临时指针cur指向根节点，不断判断cur的数据值与key的大小 ...直到相等返回true 反之false
     * 结束条件为cur 为空
     * @param key
     * @return
     */
    public boolean searchBST(int key){
        Node cur = this.root;
        while(null != cur){
            if(key == cur.data){
                return true;
            }else if(key < cur.data){
                cur = cur.lchild;
            }else{
                cur = cur.rchild;
            }
        }
        return false;
    }

    /**
     * 二叉排序树的插入：
     * 首先从根节点开始遍历当前的二叉排序树，如果当前树为空则根节点为插入的新节点
     * 反之定义临时指针p（指向当前遍历的节点）和 pre（当前节点的双亲节点）
     * 判断p节点的数据值与key的大小 直到遍历到p为空为止 此时它的双亲节点（pre）的左孩子
     * 或者右孩子的位置为空，也就是key要插入的位置
     * 找到插入位置后，判断pre的数据值与key的大小 key < pre.data key插为左孩子 反之插为右孩子
     *
     * @param key
     */
    public void InsertBST(int key){
        Node p = this.root;
        Node pre = null;
        while(null != p){
            pre = p;
            if(key < p.data){
                p = p.lchild;
            }else if(key > p.data){
                p = p.rchild;
            }else{
                return;
            }
        }
        if(null == this.root){
            this.root = new Node(key);
        }else if(key < pre.data){
            pre.setLchild(new Node(key));
        }else{
            pre.setRchild(new Node(key));
        }
    }

    /**
     * 中序遍历二叉树
     * 省略
     */

    /**
     * 二叉排序树的删除主要分为四种情况：
     * 1.要删除的节点为叶子节点
     * 2.要删除的节点只有左子树
     * 3.要删除的节点只有右子树
     * 4.要删除的节点既有左子树又有右子树
     * ---》1.叶子节点的判断条件是node的左右子树都为空 ，此时还需分两种情况
     *           1.1 当前要删除的节点在它前驱节点（pre）的左边 则 pre的左子树置为空
     *           1.2 当前要删除的节点在它前驱节点（pre）的右边 则 pre的右子树置为空
     * ---》2.对于第二种情况 直接用pre的右孩子节点指向要删除节点的右孩子节点
     * ---》3.对于第三种情况 直接用pre的左孩子节点指向要删除节点的左孩子节点
     * @param node
     * @param pre
     * @return
     */
    public boolean delete(Node node,Node pre){
        Node temp = null;
        if(null == node.rchild && null == node.lchild){
            if(pre.data < node.data){
                pre.rchild = null;
            }else{
                pre.lchild = null;
            }
            return true;
        }
        if(null == node.lchild){
              pre.rchild = node.rchild;
              return true;
        }
        if(null == node.rchild){
             pre.lchild = node.lchild;
             return true;
        }else{
            temp = node;
            Node p = node;
            p = p.lchild;
            while(null != p.rchild){
                temp = p;
                p = p.rchild;
            }
            node.data = p.data;
            if(temp != node){
                temp.rchild = p.lchild;
            }else{
                temp.lchild = p.lchild;
            }
            return true;
        }
    }

    /**
     * 查找要删除的节点和它的双亲节点
     * @param node
     * @param pre
     * @param key
     * @return
     */
    public boolean deleteBST(Node node,Node pre,int key){
        if(null == node){
           return false;
        }
        if(key == node.data){
            return delete(node,pre);
        }else if(key < node.data){
            pre = node;
            return deleteBST(node.lchild,pre,key);
        }else{
            pre = node;
           return deleteBST(node.rchild,pre,key);
        }
    }

    /**
     * 对当前二叉排序树做删除操作
     * @param key
     */
    public void deleteBST(int key){
        deleteBST(this.root,null,key);
    }
}
