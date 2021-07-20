package com.zhulin.shuati.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 题目：102 二叉树的层次遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LevelOrder {

    /**
     * 标准的广度优先遍历
     */
    public List<Integer> levelOrder(TreeNode root) {
        List<Integer> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            lists.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return lists;
    }

    /**
     * 我们可以用一种巧妙的方法修改 BFS：
     *
     * 首先根元素入队,当队列不为空的时候,求当前队列的长度 s_i
     *
     * 依次从队列中取 s_i个节点元素进行拓展，然后进入下一次迭代
     * 它和 BFS 的区别在于 BFS 每次只取一个元素拓展，而这里每次取 s_i个元素。
     *
     * 比如第一层就是s_i个元素为1，第二层就是2
     * 在上述过程中的第 i 次迭代就得到了二叉树的第 i 层的 s_i个元素。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/er-cha-shu-de-ceng-xu-bian-li-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }


    public static List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        Queue<List<TreeNode>> queues = new LinkedList<>();
        if (root == null){
            return results;
        }
        queues.add(Collections.singletonList(root));
        while (!queues.isEmpty()){
            List<TreeNode> node = queues.remove();
            List<TreeNode> queue = new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            for (TreeNode treeNode : node) {
                result.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            if (!queue.isEmpty()){
                queues.add(queue);
            }
            results.add(result);
        }
        return results;
    }

    public static void main(String[] args) {
        levelOrder2(new TreeNode(2));
    }
}
