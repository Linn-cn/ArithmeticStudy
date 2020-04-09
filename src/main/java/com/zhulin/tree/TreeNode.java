package com.zhulin.tree;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname TreeNode
 * @description 树节点
 * @create 2020-04-04 20:10
 **/
public class TreeNode<T> {

    private int index;
    private T data;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;

    public TreeNode(int index, T data) {
        this.index = index;
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }
}
