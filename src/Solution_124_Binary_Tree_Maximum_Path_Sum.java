/**
 * 
 * Binary Tree Maximum Path Sum
 * 
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * For example:
 * Given the below binary tree,
 * 
 *        1
 *       / \
 *      2   3
 * Return 6.
 *
 */
/*
 * Notice:  From this line: http://blog.csdn.net/fightforyourdream/article/details/16894069
 * 			For each node like following, there should be four ways existing for max path:
 * 			1. Node only （因为本题中的节点可能是负值！）
 * 			2. L-sub + Node
 * 			3. R-sub + Node
 * 			4. L-sub + Node + R-sub
 * 
 * Time: O(n), Space: O(logn)
 * 
 */

public class Solution_124_Binary_Tree_Maximum_Path_Sum {
	public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] result = {Integer.MIN_VALUE};
        helper(root, result);
        return result[0];
    }
    
    public int helper(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }
        
        int left = helper(root.left, result); // 左子树的最大和  
        int right = helper(root.right, result); // 右子树的最大和  
        int arch = left + root.val + right; // 从左子树经过root到右子树的最大和
        
        // 表示通过root节点能走到root的parent的最大和，这个值作为返回对象返给调用父函数
        // 只有3中情况: 1 从左子树到root再到parent
        // 2 从右子树到root再到parent
        // 3 直接从root到parent
        // 注意arch那条路是不可能走到parent，因为那条路已经经过root了，除非折回来重复走！但这是不允许的
        
        int maxPathAcrossRootToParent = Math.max(root.val, Math.max(left, right) + root.val);
        
        // max[0] 保存在所有递归过程中的最大值，这时也要考虑arch可能最大
        result[0] = Math.max(result[0], Math.max(arch, maxPathAcrossRootToParent));
        
        return maxPathAcrossRootToParent;
    }
}
