package com.zhulin.shuati.niuke;

import com.zhulin.shuati.leetcode.simple.ReverseList.ListNode;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 *
 * https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&&tqId=11156&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * @author Linn-cn
 * @create 2020/10/11
 */
public class ListFromTailToHead {
    public static void main(String[] args) {

    }

    /**
     * ArrayList 中有个方法是 add(index,value)，可以指定 index 位置插入 value 值
     * 所以我们在遍历 listNode 的同时将每个遇到的值插入到 list 的 0 位置，最后输出 listNode 即可得到逆序链表
     * @param listNode
     * @author Linn-cn
     * @date 2020/10/11
     */
    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode tmp = listNode;
        while (tmp != null) {
            list.add(0, tmp.val);
            tmp = tmp;
        }
        return list;
    }


    public static ArrayList<Integer> arrayList = new ArrayList<>();
    /**
     * 既然非递归都实现了，那么我们也可以利用递归，借助系统的"栈"帮忙打印
     * @param listNode
     * @author Linn-cn
     * @date 2020/10/11
     */
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode != null){
            printListFromTailToHead2(listNode);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}
