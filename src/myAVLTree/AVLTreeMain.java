package myAVLTree;

/**
 * Created by hpx on 2018/3/9.
 */
public class AVLTreeMain {
    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        Integer  arr[]= {3,2,1,4,5,6,7,16,15,14,13,12,11,10,8,9};
        for(int i = 0;i < arr.length; i++){
            avlTree.insert(arr[i]);
        }
        avlTree.preOrder();
        System.out.println();
        avlTree.delete(7);
        avlTree.preOrder();
    }
}
