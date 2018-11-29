/**
 * #24
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 说明:
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapPairs {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //fixme 1
    public static ListNode swapPairs(ListNode head) {
        ListNode curNode = head;
        int count = 0;
        if (head == null || head.next == null) return head;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            ListNode stepNode = null;
            if (nextNode == null) break;
            if (nextNode.next != null) {
                stepNode = nextNode.next;
                if (nextNode.next.next != null) {
                    curNode.next = nextNode.next.next;
                } else {
                    curNode.next = nextNode.next;
                }
            } else {
                curNode.next = null;
            }
            nextNode.next = curNode;
            curNode = stepNode;
            if (count == 0) head = nextNode;
            count++;
        }
        return head;
    }

    public static void main(String arg[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode listNode = swapPairs(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
