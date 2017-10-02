
/**
 * Created by Swathi on 8/18/2017.
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class L230 {

    public static void main(String[] args){
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        System.out.println(kthSmallest(node,1));
    }
    private static int count = 0;
    public static int kthSmallest(TreeNode root, int k) {
        return traverse(root,k);

    }

    static int traverse(TreeNode node, int k)
    {
        if (node == null)
            return 0;

        traverse(node.left,k);

        count++;
        if(count==k){
            return node.val;
        }

        traverse(node.right,k);
        return 0;
    }
}
