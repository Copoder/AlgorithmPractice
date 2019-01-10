/**
 * #43
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class MultiplyString {
    public static void main(String args[]) {
        System.out.println(multiply2("0", "0"));
    }

    //第一次 受限于int的最大值
    public static String multiply(String num1, String num2) {
        int result = 0;
        for (int i = 0; i < num1.length(); i++) {
            int temp = 0, count = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int base = ((int) num1.charAt(i) - '0') * ((int) num2.charAt(j) - '0');
                count += Math.pow(10, num2.length() - j - 1) * base + temp;
                temp = base / 10;
            }
            result += count * Math.pow(10, num1.length() - i - 1);
        }
        return String.valueOf(result);
    }

    public static String multiply2(String num1, String num2) {
        char[] result = new char[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                result[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int carry = 0;
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] += carry;
            carry = result[i] / 10;
            result[i] = (char) (result[i] % 10 + '0');
        }
        int start = 0;
        while (result[start] == '0' && start < result.length - 1) {
            start++;
        }
        return new String(result, start, result.length - start);
    }
}
