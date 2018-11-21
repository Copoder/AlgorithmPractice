/**
 * #19
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthFromEnd {
    public static void main(String args[]) {
        int[] a = {11};
        ListNode node = new ListNode(a[0]);
        ListNode copyHead = node;
        for (int i = 1; i < a.length; i++) {
            node.next = new ListNode(a[i]);
            node = node.next;
        }
        ListNode listNode = removeNthFromEnd2(copyHead, 1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    // 第一次通过 两次遍历法
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        int length = 1;
        ListNode curNode = head;
        while (curNode.next != null) {
            length++;
            curNode = curNode.next;
        }
        ListNode node = head;
        ListNode pre = head;
        for (int i = 0; i < length - n; i++) {
            pre = node;//记录最后一个节点的父节点
            node = node.next;
        }
        if (node == head) {
            head = node.next;
        }
        if (node != null) {
            pre.next = node.next;
        }
        return head;

    }

    //      Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
