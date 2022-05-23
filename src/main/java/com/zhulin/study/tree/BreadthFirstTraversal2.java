package com.zhulin.study.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 广度优先遍历
 *
 * @author Zhu Lin
 * @date 2022/4/13
 */
public class BreadthFirstTraversal2 {

    public List<List<Object>> levelOrder(TreeNode root) {
        List<List<Object>> ans = new ArrayList<>();
        // 初始化当前层结点
        List<TreeNode> curLevel = new ArrayList<>();
        // 注意：需要root不空的时候才加到里面。
        if (root != null) {
            curLevel.add(root);
        }
        while (curLevel.size() > 0) {
            // 准备用来存放下一层的结点
            List<TreeNode> nextLevel = new ArrayList<>();
            // 用来存放当前层的结果
            List<Object> curResult = new ArrayList<>();
            // 遍历当前层的每个结点
            for (TreeNode cur : curLevel) {
                // 把当前层的值存放到当前结果里面
                curResult.add(cur.data);
                // 生成下一层
                if (cur.left != null) {
                    nextLevel.add(cur.left);
                }
                if (cur.right != null) {
                    nextLevel.add(cur.right);
                }
            }
            // 注意这里的更迭!滚动前进
            curLevel = nextLevel;
            // 把当前层的值放到结果里面
            ans.add(curResult);
        }
        return ans;
    }

}
