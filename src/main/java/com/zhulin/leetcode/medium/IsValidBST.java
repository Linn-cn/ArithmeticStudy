package com.zhulin.leetcode.medium;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class IsValidBST {

    private static Integer pre = Integer.MIN_VALUE;

    public static void main(String[] args) {
        System.out.println(isValidBST(new TreeNode(0)));
    }

    public static boolean isValidBST(TreeNode root) {
        return helper(root);
    }

    /**
     * 用递归法实现。首先将结点的值与上界和下界（如果有）比较。然后，对左子树和右子树递归进行该过程。
     * @param node 当前节点
     * @param lower 上界
     * @param upper 下界
     * @return
     */
    public static boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (! helper(node.right, val, upper)) return false;
        if (! helper(node.left, lower, val)) return false;
        return true;
    }

    public static boolean helper(TreeNode node) {
        if (node == null) return true;
        if (!helper(node.left)) return false;
        if (node.val <= pre) return false;
        else pre = node.val;
        if (!helper(node.right)) return false;
        return true;
    }
}
