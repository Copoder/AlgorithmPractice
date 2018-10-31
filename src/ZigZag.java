import java.util.ArrayList;
import java.util.List;

/**
 * #6
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
 * <p>
 * 实现一个将字符串进行指定行数变换的函数:
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "PAYPALISHIRING", numRows = 3
 * 输出: "PAHNAPLSIIGYIR"
 * 示例 2:
 * <p>
 * 输入: s = "PAYPALISHIRING", numRows = 4
 * 输出: "PINALSIGYAHRPI"
 * 解释:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ZigZag {
    public static void main(String args[]) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }


    public static String convert(String s, int rowNums) {
        List<StringBuffer> stringBuffers = new ArrayList<>();
        for (int i = 0; i < rowNums; i++) {
            stringBuffers.add(new StringBuffer());
        }
        int xIndex = 0;//直线路径坐标
        int zIndex = 0;//斜线路径坐标
        for (int i = 0; i < s.length(); i++) {
            if (zIndex < rowNums) {
                //直线路径
                stringBuffers.get(zIndex).append(s.substring(i, i + 1));
                zIndex++;
            } else {
                //斜线路径
                stringBuffers
                        .get(stringBuffers.size() - xIndex - 2)
                        .append(s.substring(i, i + 1));
                xIndex++;
                if (xIndex == rowNums - 2) {
                    //完成一次斜线摆放,重置条件
                    zIndex = 0;
                    xIndex = 0;
                }
            }
        }
        StringBuffer buffer = new StringBuffer();
        for (StringBuffer b : stringBuffers) {
            buffer.append(b);
        }
        System.out.println(stringBuffers);
        return buffer.toString();
    }
}
