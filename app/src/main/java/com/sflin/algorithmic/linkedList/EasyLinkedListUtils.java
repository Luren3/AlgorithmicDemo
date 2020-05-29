package com.sflin.algorithmic.linkedList;

/**
 * Created by MagicFrost
 *
 * 简单链表算法
 */
public class EasyLinkedListUtils {

    /**
     * 删除链表中的节点
     *
     * @param node 示例
     *             输入: head = [4,5,1,9], node = 5
     *             输出: [4,1,9]
     *             解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     */
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }

    /**
     * 反转链表
     *
     * @param head
     * @return 示例
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, now = head;
        while (now != null) {
            ListNode next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        return pre;
    }
//    public static ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) return head;
//        List<Integer> list = new ArrayList<>();
//        list.add(head.val);
//        while (head.next != null){
//            list.add(head.next.val);
//            head = head.next;
//        }
//        ListNode newNode = null;
//        ListNode temp = null;
//        for (int i = list.size() - 1;i>=0;i--){
//            if (newNode == null){
//                newNode = new ListNode(list.get(i));
//                temp = newNode;
//            }else {
//                temp.next = new ListNode(list.get(i));
//                temp = temp.next;
//            }
//        }
//        return newNode;
//    }

    /**
     * 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     *
     * 示例
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 类似归并排序中的合并过程
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummyHead.next;
    }
//    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null) return l2;
//        if (l2 == null) return l1;
//        List<Integer> list = new ArrayList<>();
//        list.add(l1.val);
//        while (l1.next != null){
//            list.add(l1.next.val);
//            l1 = l1.next;
//        }
//        list.add(l2.val);
//        while (l2.next != null){
//            list.add(l2.next.val);
//            l2 = l2.next;
//        }
//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
//
//        ListNode newNode = null;
//        ListNode temp = null;
//        for (int i = 0; i < list.size(); i ++) {
//            if (newNode == null) {
//                newNode = new ListNode(list.get(i));
//                temp = newNode;
//            } else {
//                temp.next = new ListNode(list.get(i));
//                temp = temp.next;
//            }
//        }
//        return newNode;
//    }

    /**
     * 回文链表
     * @param head
     * @return
     *
     * 示例
     * 输入: 1->2->2->1
     * 输出: true
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 找到链表的中点
        ListNode mid = middleNode(head);
        // 翻转中点后的链表
        mid = reverseList(mid);
        // 比较两段链表
        while (mid != null) {
            if (head.val != mid.val) {
                return false;
            }
            head = head.next;
            mid = mid.next;
        }
        return true;
    }
//    public static boolean isPalindrome(ListNode head) {
//        List<Integer> list = new ArrayList<>();
//        while (head != null){
//            list.add(head.val);
//            head = head.next;
//        }
//        for (int i = 0;i < list.size() / 2;i ++){
//            int num1 = list.get(i);
//            int num2 = list.get(list.size() - 1 - i);
//            if (num1 != num2){
//                return false;
//            }
//        }
//        return true;
//    }

    /**
     * 环形链表
     *
     * @param head
     * @return
     *
     * 示例
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 相交链表
     *
     * @param headA
     * @param headB
     * @return
     * 示例
     *
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     * 输出：Reference of the node with value = 8
     * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0,lenB = 0;
        ListNode longNode = headA,shortNode = headB;
        while (longNode != null){
            lenA++;
            longNode = longNode.next;
        }
        while (shortNode != null){
            lenB++;
            shortNode = shortNode.next;
        }
        if (lenA < lenB){
            longNode = headB;
            shortNode = headA;
        }else {
            longNode = headA;
            shortNode = headB;
        }
        int len = Math.abs(lenA - lenB);
        for (int i = 0;i < len;i++){
            longNode = longNode.next;
        }

        while (longNode != shortNode){
            longNode = longNode.next;
            shortNode = shortNode.next;
        }
        return longNode;
    }

    /**
     * 876. 链表的中间结点
     *
     * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     *
     * @param head
     * @return
     *
     * 示例
     * 输入：[1,2,3,4,5,6]
     * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
     * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
     */
    public static ListNode   middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
