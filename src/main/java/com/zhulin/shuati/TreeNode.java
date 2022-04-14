package com.zhulin.shuati;

/**
 * 树节点
 *
 * @author Zhu Lin
 * @date 2022/4/13
 */
public class TreeNode<T> {

    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
        this.left = null;
    }
}
