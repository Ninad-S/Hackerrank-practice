/* A binary tree node class
class Node
{
    int data;
    Node left,right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
} */

class Solution {
    public int height(Node root) {
        // code here
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }
    public boolean isBalanced(Node root) {
        // code here
        if (root == null)
        {
            return true;
        }
        int l = height(root.left);
        int r = height(root.right);
        if (Math.abs(l-r) > 1)
        {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
        
    }
}
