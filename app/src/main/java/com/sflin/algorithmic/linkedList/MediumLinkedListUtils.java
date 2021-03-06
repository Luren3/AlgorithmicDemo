package com.sflin.algorithmic.linkedList;

import java.util.*;

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

    /**
     * 排序链表
     *
     * @param head
     * @return
     * 示例
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     */
    public static ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    private static ListNode mergeSort(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode tmp = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            tmp = slow;
            slow = slow.next;
        }
        tmp.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(slow);
        return merge(l,r);
    }
    private static ListNode merge(ListNode l,ListNode r){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(l != null && r != null){
            if(l.val < r.val){
                cur.next = l;
                cur = cur.next;
                l = l.next;
            }
            else{
                cur.next = r;
                cur = cur.next;
                r = r.next;
            }
        }
        if(l != null)
            cur.next = l;
        if(r != null)
            cur.next = r;
        return head.next;
    }
//    public static ListNode sortList(ListNode head) {
//        List<Integer> list = new ArrayList<>();
//        while (head != null){
//            list.add(head.val);
//            head = head.next;
//        }
//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
//        ListNode temp = null;
//        for (int val:list){
//            if (head == null){
//                head = new ListNode(val);
//                temp = head;
//            }else {
//                temp.next = new ListNode(val);
//                temp = temp.next;
//            }
//        }
//        return head;
//    }

    /**
     * 奇偶链表
     *
     * @param head
     * @return
     * 示例
     * 输入: 1->2->3->4->5->NULL
     * 输出: 1->3->5->2->4->NULL
     */
    public static ListNode oddEvenList(ListNode head) {
        ListNode odd = null,even = null;
        ListNode oddCur = null;
        ListNode evenCur = null;
        int index = 1;
        while (head != null){
            if (index%2 == 0){
                if (even == null){
                    even = new ListNode(head.val);
                    evenCur = even;
                }else {
                    evenCur.next = new ListNode(head.val);
                    evenCur = evenCur.next;
                }
            }else {
                if (odd == null){
                    odd = new ListNode(head.val);
                    oddCur = odd;
                }else {
                    oddCur.next = new ListNode(head.val);
                    oddCur = oddCur.next;
                }
            }
            head = head.next;
            index++;
            if (head == null){
                oddCur.next = even;
            }
        }
        return odd;
    }
}
