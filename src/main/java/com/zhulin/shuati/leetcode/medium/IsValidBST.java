package com.zhulin.shuati.leetcode.medium;

import java.util.Stack;

/**
 * 98. 题目：验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
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
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);

        node5.left = node1;
        node5.right = node4;
        node4.left = node3;
        node4.right = node6;
        System.out.println(isValid(node5,null,null));
    }

    public static boolean isValidBST(TreeNode root) {
        return helper2(root);
    }

    /**
     * 用递归法实现。首先将结点的值与上界和下界（如果有）比较。然后，对左子树和右子树递归进行该过程。
     *
     * @param node  当前节点
     * @param lower 上界
     * @param upper 下界
     * @return
     */
    public static boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        // 遍历左子树
        if (!helper(node.right, val, upper)) return false;
        // 遍历右子树
        if (!helper(node.left, lower, val)) return false;
        return true;
    }


    /**
     * 中序遍历
     * @param root
     * @author Linn-cn
     * @date 2020/10/12
     */
    public static boolean helper2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    public static boolean isValid(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }
        return isValid(root.left, min, root.val) &&
                isValid(root.right, root.val, max);
    }
}
