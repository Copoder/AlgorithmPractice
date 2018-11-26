import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * #23
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeKLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            while (node != null) {
                list.add(node.val);
                node = node.next;
            }
        }
        if(list.size() == 0) return null;
        Object[] ints = list.toArray();
        Arrays.sort(ints);
        ListNode head = new ListNode((Integer) ints[0]);
        ListNode listNode = head;
        for (int i = 1; i < ints.length; i++) {
            listNode.next = new ListNode((Integer) ints[i]);
            listNode = listNode.next;
        }
        return head;
    }
}
