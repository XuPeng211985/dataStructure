package search;

/**
 * Created by hpx on 2018/3/7.
 */
public class SearchBSTMain {
    public static void main(String[] args) {
        SearchBST searchBST = new SearchBST();
        int[] arr = {44,21,65,14,32,58,72,80};
        for (int i = 0; i < arr.length; i++) {
            searchBST.InsertBST(arr[i]);
        }
        searchBST.Recursion_Inorder();
        //System.out.println(searchBST.searchBST(4));
        System.out.println();
        searchBST.deleteBST(80);
        searchBST.Recursion_Inorder();
    }
}
