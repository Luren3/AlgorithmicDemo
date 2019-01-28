package com.sflin.algorithmic.linkedList;

/**
 * Created by SFLin
 * <p>
 * 初级链表算法
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
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
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

        if (head.next.next == null) {
            return head.val == head.next.val;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast.next != null) {
            // 不停的从slow的后一个开始遍历，知道找到值相同的节点
            // 一次完成后，再移动到原节点的下一个节点开始，继续重复上面的步骤
            if (fast.next.val == slow.val) {
                if (fast.next.next != null) {
                    return false;
                }
                fast.next = null;
                slow = slow.next;
                fast = slow.next;
                if (fast == null || fast.val == slow.val) {
                    return true;
                }
            } else {
                fast = fast.next;
            }
        }
        return false;
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
}
