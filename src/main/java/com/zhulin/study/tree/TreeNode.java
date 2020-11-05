package com.zhulin.study.tree;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname TreeNode
 * @description 树节点
 * @create 2020-04-04 20:10
 **/
public class TreeNode<T> {

    // public int index;
    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode( T data) {
        // this.index = Integer.parseInt(null);
        this.data = data;
        this.left = null;
        this.left = null;
    }
}
