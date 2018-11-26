import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * #21
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4
 */
public class MergeTowLists {
    public static void main(String args[]){

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList();
        ListNode node = l1;
        while (node != null){
            list.add(node.val);
            node = node.next;
        }
        node = l2;
        while (node != null){
            list.add(node.val);
            node = node.next;
        }
        if(list.size() == 0) return null;
        Object[] ints =  list.toArray();
        Arrays.sort(ints);
        ListNode head = new ListNode((Integer) ints[0]);
        node = head;
        for(int i = 1;i<ints.length;i++){
            node.next = new ListNode((Integer) ints[i]);
            node = node.next;
        }
        return head;
    }


  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

}
