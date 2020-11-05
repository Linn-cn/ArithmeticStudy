package com.zhulin.study.tree;

import java.util.ArrayList;

/**
 * 深度优先搜索
 *
 * @author Linn-cn
 * @create 2020/10/14
 */
public class DepthFirstSearch {

    public static void dfs(TreeNode node, ArrayList<TreeNode> list) {
        if (list.contains(node)) {
            return;
        }
        list.add(node);
        dfs(node.left, list);
        dfs(node.right, list);

    }
}
