package com.sflin.algorithmic.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MagicFrost
 *
 * 中等链表算法
 */
public class MediumLinkedListUtils {

    /**
     * 删除链表的倒数第N个节点
     *
     * @param head
     * @param n
     * @return 示例
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * <p>
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) return head;
        int index = 1;
        ListNode temp = head;
        while (temp.next != null) {
            index++;
            temp = temp.next;
        }

        if (index == 1 && n == 1) return null;

        int i = 0;
        temp = head;
        while (temp.next != null) {
            if (n == 1 && i == index - n - 1) {
                temp.next = null;
                return head;
            }
            if (index == n) {
                head.val = head.next.val;
                head.next = head.next.next;
                return head;
            }
            if (i == index - n) {
                temp.val = temp.next.val;
                temp.next = temp.next.next;
                return head;
            }
            i++;
            temp = temp.next;
        }
        return head;
    }

    /**
     * 复制带随机指针的链表
     *
     * @param head
     * @return
     *
     * 示例
     * 输入：
     * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
     *
     * 解释：
     * 节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
     * 节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
     */
    public static Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();

        Node node = head;
        while (node != null){
            Node newNode = new Node(node.val,null,null);
            map.put(node,newNode);
            node = node.next;
        }
        node = head;
        while (node != null){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
}
