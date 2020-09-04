package com.zhulin.shuati.leetcode.medium;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
        // 1 -> 2 -> 3 -> 4
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        /*
         * 删除链表
         * 2 -> ? = (2 -> 3 -> 4)
         * 2 -> 4
         */
        // node2.next = node2.next.next;

        /*
         * 插入链表
         * 3 -> ? = 2 -> 4
         * 3 -> 4
         */
        // node3.next = node2.next;
        // node2.next = node3;

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

    /**
     * 如果一个问题 A 可以分解为若干子问题 B、C、D，你可以假设子问题 B、C、D 已经解决，在此基础上思考如何解决问题 A。
     * 而且，你只需要思考问题 A 与子问题 B、C、D 两层之间的关系即可，不需要一层一层往下思考子问题与子子问题，子子问题与子子子问题之间的关系。屏蔽掉递归细节，这样子理解起来就简单多了。
     * @param head
     * @author Linn-cn
     * @date 2020/8/8
     */
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
