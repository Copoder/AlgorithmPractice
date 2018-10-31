import java.util.Stack;

/**
 * #7 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储 32 位有符号整数，
 * 其数值范围是 [−2^31,  2^31 − 1]。根据这个假设，
 * 如果反转后的整数溢出，则返回 0。
 */
public class ReverseInteger {
    public static void main(String args[]) {
        System.out.println(reverse(1534236469));
    }

    //todo 没有考虑位数与溢出的情况
    public static int reverse(int x) {
        if(x>=Math.pow(2,31)) return 0;
        int xCopy = x, count = 0;
        while (xCopy != 0) {
            xCopy /= 10;
            count++;
        }
        xCopy = x;
        int reverse = 0;
        Stack<Integer> stack = new Stack();
        for (int i = count; i > 0; i--) {
            int pow = (int) Math.pow(10, i - 1);
            stack.push(xCopy / pow);
            xCopy = xCopy % pow;
        }
        for(int i = count;i>0;i--){
            reverse = (int) (reverse + stack.pop()*Math.pow(10,i-1));
        }
        return reverse;
    }
}
