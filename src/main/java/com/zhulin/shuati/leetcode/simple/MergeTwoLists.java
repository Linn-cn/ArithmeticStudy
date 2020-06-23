package com.zhulin.shuati.leetcode.simple;

/**
 * 题目：合并两个有序列表
 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4
 **/

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);

        listNode1.next = listNode2;
        ListNode head = listNode1;
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 虚假链表头
        ListNode prehead = new ListNode(-1);

        // 头指针
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 因为两个链表本身有序，所以当一个链表迭代完了，另一个直接拼在后面即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}
