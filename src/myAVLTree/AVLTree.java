package myAVLTree;

/**
 * Created by hpx on 2018/3/8.
 */
public class AVLTree <T extends Comparable<T>>{
    private Node root;

    /**
     * 获取以node为根节点的子树的高度
     * @param node
     * @return
     */
    public int getHight(Node node){
        return null == node ? 0 : node.hight;
    }
    /**
     * 获取当前AVL树的高度
     * @return
     */
    public int getHight(){
        return getHight(this.root);
    }

    /**
     * 中序遍历平衡二叉排序树
     */
    public void preOrder(){
        preOrder(this.root);
    }
    private void preOrder(Node root){
        if(null == root){
            return;
        }
        preOrder(root.lchild);
        System.out.print(root.data + " ");
        preOrder(root.rchild);
    }
    /**
     * 在当前树中查找 值为key的节点
     * @param root 根节点
     * @param key 将要查找的数据值
     * @return
     */
    private Node search(Node root,T key){
        while(null != root){
            if(root.data.compareTo(key) == 0){
                return root;
            }
            if(root.data.compareTo(key) < 0){
                root = root.lchild;
            }else{
                root = root.rchild;
            }
        }
        return null;
    }
    public Node search(T key){
        return search(this.root,key);
    }
    /**
     * LL旋转：
     *    定义一个临时节点 p 指向旋转前根节点 root 的左孩子
     *    root 的左孩子节点孩子指向 p 的右孩子节点指
     *    p的右孩子节点指向root
     *    接着分别设置 root和p的高度：
     *        root是p的右孩子节点，所以优先计算  root.hight = 左孩子和右孩子高度的最大值加1
     *        随后p.hight = 左孩子节点和root高度的最大值加1
     *   最后返回旋转后的根节点
     * @param root 旋转前的根节点
     * @return旋转后的根节点
     */
    private Node leftLeftRotation(Node root){
        Node p = root.lchild;
        root.lchild = p.rchild;
        p.rchild = root;
        root.hight = AVLTreeUtils.max(getHight(root.lchild),getHight(root.rchild)) +1;
        p.hight = AVLTreeUtils.max(getHight(p.lchild),root.hight)+1;
        return p;
    }
    /**
     * RR旋转：
     *    定义一个临时节点 p 指向旋转前根节点 root 的右孩子
     *    root 的右孩子节点孩子指向 p 的左孩子节点
     *    p的左孩子节点指向root
     *    接着分别设置 root和p的高度：
     *        root是p的左孩子节点，所以优先计算  root.hight = 左孩子和右孩子高度的最大值加1
     *        随后p.hight = 右孩子节点和root高度的最大值加1
     *   最后返回旋转后的根节点
     * @param root 旋转前的根节点
     * @return旋转后的根节点
     */
    private Node rightRightRotation(Node root){
        Node p = root.rchild;
        root.rchild = p.lchild;
        p.lchild = root;
        root.hight = AVLTreeUtils.max(getHight(root.lchild),getHight(root.rchild))+1;
        p.hight = AVLTreeUtils.max(getHight(p.rchild),root.hight)+1;
        return p;
    }

    /**
     * LR旋转:
     *    首先以当前根节点的左孩子节点为旋转点进行RR旋转
     *    并且将旋转后子树的根节点挂在当前根节点的左孩子节点上
     *    最后再已当前根节点为旋转点进行LL旋转
     * @param node 当前根节点
     * @return 旋转后的根节点
     */
    private Node leftRightRotation(Node node){
        node.lchild =  rightRightRotation(node.lchild);
        return leftLeftRotation(node);
    }
    /**
     * RL旋转:
     *    首先以当前根节点的右孩子节点为旋转点进行RR旋转
     *    并且将旋转后子树的根节点挂在当前根节点的右孩子节点上
     *    最后再已当前根节点为旋转点进行RR旋转
     * @param node 当前根节点
     * @return 旋转后的根节点
     */
    private Node rightLeftRotation(Node node){
        node.rchild = leftLeftRotation(node.rchild);
        return rightRightRotation(node);
    }

    /**
     * AVL树的插入：刚开始肯定是递归的结束条件 》若当前节点为空 则把值为key的新节点传给当前节点
     *              反之则判断当前节点的数值和要插入数值的大小，大的向右边插 小的向左边插 相等则插入失败
     *             在插入的过程中还要判断，新节点的插入有没有破坏AVL树的平衡：
     *             1，左边插入破坏平衡分两种情况 第一 key插在节点的左边 则需要LL旋转
     *                第二 key 插在节点的右边 则需要LR旋转
     *             2，右边插入破坏平衡同样分两种情况 第一 key插在节点的右边 则需要RR旋转
     *                第二 key 插在节点的左边 则需要 RL旋转
     *          最后，计算树的高度 返回根节点
     *
     *
     * @param root
     * @param key
     * @return
     */
    private Node insert(Node root,T key){
        if(null == root){
            root = new Node(key);
            return root;
        }
        int temp = root.data.compareTo(key);
        if(0 == temp){
            System.out.println("该值在树中已经存在，无法插入！");
            return root;
        }
        if(0 > temp){
            root.rchild = insert(root.rchild,key);
            if(getHight(root.rchild) - getHight(root.lchild) == 2){
                if(root.rchild.data.compareTo(key) > 0){
                   root = rightLeftRotation(root);
                }else{
                   root = rightRightRotation(root);
                }
            }
        }else{
            root.lchild = insert(root.lchild,key);
            if(getHight(root.lchild) - getHight(root.rchild) == 2){
                if(root.lchild.data.compareTo(key) > 0){
                    root = leftLeftRotation(root);
                }else{
                    root = leftRightRotation(root);
                }
            }
        }
        root.hight = AVLTreeUtils.max(getHight(root.rchild),getHight(root.lchild)) + 1;
        return root;
    }
    public void insert(T key){
        this.root = insert(this.root,key);
    }
    private Node findMin(Node node){
        if(null == node){
            return null;
        }
        while(null != node.lchild){
            node = node.lchild;
        }
        return node;
    }
     private Node delete(Node node,T key) {
         if (null == node) {
             return null;
         }
         int temp = node.data.compareTo(key);
         if (0 < temp) {
             node.lchild = delete(node.lchild, key);
         } else if (0 > temp) {
             node.rchild = delete(node.rchild, key);
         } else if (node.lchild != null && node.rchild != null) {
             node.data = findMin(node.rchild).data;
             node.rchild = delete(node.rchild, (T) node.data);
         } else {
             node = (null == node.rchild) ? node.lchild : node.rchild;
         }
         if(null == node){
             return null;
         }
         if ((getHight(node.rchild) - getHight(node.lchild)) > 1) {
             if(getHight(node.rchild.rchild) > getHight(node.rchild.lchild)){
                 node = rightRightRotation(node);
             }else{
                 node = rightLeftRotation(node);
             }
         }
         if((getHight(node.lchild) - getHight(node.rchild)) > 1){
             if(getHight(node.lchild.lchild) > getHight(node.lchild.rchild)){
                 node = leftLeftRotation(node);
             }else{
                 node = leftRightRotation(node);
             }
         }
         return node;
     }
     public void delete(T key){
        this.root = delete(this.root,key);
     }
    private class Node<T extends Comparable>{
        private T data;
        private Node rchild;
        private Node lchild;
        private int hight;

        /**
         * 一个独立节点为高度是1的树
         * @param data
         */
        public Node(T data){
            this.data = data;
            this.hight = 1;
        }
    }
}
