package com.zhulin.leetcode.medium;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname SwapPairs
 * @description
 * @create 2020-03-10 11:53
 **/
public class SwapPairs {

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        swapPairs1(node1);
        System.out.println(node4);
    }

    // 1 -> 2 -> 3 -> 4
    public static ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode secondNode = head.next;  // 1->next = 2
        ListNode result = secondNode;
        while (secondNode != null) {
            // 第一次交换 1 -> 2 ->3   head = 1，secondNode = 2，temp = 3
            ListNode temp = secondNode.next;  // 2 -> 3
            secondNode.next = head; // 2 -> next = 1
            if (temp == null){
                head.next = null;
                break;
            }else {
                head.next = (temp.next == null ? temp : temp.next); // 1 -> next = 4  2 -> [1,3] -> 4
            }
            head = temp; // 1 -> 3
            secondNode = head.next; // 2 -> 4
        }
        return result;
    }

    public static ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs2(next.next);
        next.next = head;
        return next;
    }
}
