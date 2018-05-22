package mybinarytree;

/**
 * Created by hpx on 2018/3/6.
 */
public class BinarytreeMain {
    public static void main(String[] args) {
        String source = "AB#D##C##";
        Binarytree tree = new Binarytree();
        Binarytree.Node root = tree.init(source);
        //tree.preorder(root);ABDC
       // tree.postorder(root);DBCA
       tree.inorder(root);//BDAC
        //tree.Non_Recursion_preOrder(root);ABDC
        //tree.Non_Recursion_Inorder(root);BDAC
       // tree.Non_Recursion_Postorder(root);DBCA
        tree.InThreading();
        System.out.println(root.getLchild().getRchild().getRchild());
    }
}
