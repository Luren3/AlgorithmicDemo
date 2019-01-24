package com.sflin.algorithmic.linkedList;

/**
 * Created by SFLin
 *
 * 初级链表算法
 */
public class EasyLinkedListUtils {

    /**
     * 删除链表中的节点
     *
     * @param node
     *
     * 示例
     * 输入: head = [4,5,1,9], node = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     */
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 删除链表的倒数第N个节点
     *
     * @param head
     * @param n
     * @return
     *
     * 示例
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) return head;
        int index = 1;
        ListNode temp = head;
        while (temp.next != null){
            index ++;
            temp = temp.next;
        }

        if (index == 1 && n == 1) return null;

        int i = 0;
        temp = head;
        while (temp.next != null){
            if (n == 1 && i == index - n - 1){
                temp.next = null;
                return head;
            }
            if (index == n){
                head.val = head.next.val;
                head.next = head.next.next;
                return head;
            }
            if (i == index - n){
                temp.val = temp.next.val;
                temp.next = temp.next.next;
                return head;
            }
            i++;
            temp = temp.next;
        }
        return head;
    }
}
