import basicstructure.SingleLinkedList;

import java.util.Stack;

/**
 * #2
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class LinkedListSum {
    public static void main(String args[]) {
        test();
    }

    //第一次
    public static SingleLinkedList<Integer>
    linkedListSum(SingleLinkedList l1, SingleLinkedList l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        for (int i = 0; i < l1.size(); i++) {
            s1.push((Integer) l1.get(i));
        }
        for (int i = 0; i < l2.size(); i++) {
            s2.push((Integer) l2.get(i));
        }
        int sum = 0;
        while (!s1.empty()) {
            sum = sum + ((int) Math.pow(10, s1.size() - 1)) * s1.pop();
        }
        while (!s2.empty()) {
            sum = sum + ((int) Math.pow(10, s2.size() - 1)) * s2.pop();
        }
        System.out.println(sum);
        int sumCopy = sum;
        //sum的位数
        int count = 0;
        while (sum != 0) {
            sum = sum / 10;
            count++;
        }
        SingleLinkedList<Integer> s3 = new SingleLinkedList<>();
        //分解int的最高位
        int cur = 0;
        Stack stack = new Stack();
        //分解并入栈
        for (int i = count - 1; i >= 0; i--) {
            cur = sumCopy / (int) Math.pow(10, i);
            sumCopy = (int) (sumCopy % Math.pow(10, i));
            stack.push(cur);
        }
        while (!stack.empty()) {
            s3.add((Integer) stack.pop());
        }
        for (int i = 0; i < s3.size(); i++) {
            System.out.println(s3.get(i));
        }
        return s3;
    }

    public static void test() {
        SingleLinkedList<Integer> s1 = new SingleLinkedList<>();
        s1.add(2);
        s1.add(4);
        s1.add(3);
        SingleLinkedList<Integer> s2 = new SingleLinkedList<>();
        s2.add(5);
        s2.add(6);
        s2.add(4);
        linkedListSum(s1, s2);
    }

}
