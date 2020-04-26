package com.zhulin.leetcode.difficulty;

/**
 * 题目：K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        int i = 0;
        while (tail != null) {
            i++;
            if (i >= k) break;
            tail = tail.next;
        }
        if (i < k) return head;
        // 反转前 k 个元素
        ListNode newHead = reverse(head, k);
        //下一轮的开始的地方就是tail
        head.next = reverseKGroup(newHead, k);

        return newHead;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null && k-- > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
