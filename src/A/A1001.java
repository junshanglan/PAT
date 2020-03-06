package A;

import java.util.Scanner;

/**
 * Calculate a+b and output the sum in standard format -- that is,
 * the digits must be separated into groups of three by commas
 * (unless there are less than four digits).
 *
 * input:
 * -1000000 9
 * output:
 * -999,991
 *
 */
public class A1001 {

    private static final char MINUS = '-';

    private static final int SEPARATE = 3;

    /**
     * 负数的时候要注意逗号的位置
     * -998
     * -1,000
     * -1,000,234
     * -10256
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input= sc.nextLine().split(" ");
        Integer A = Integer.valueOf(input[0]);
        Integer B = Integer.valueOf(input[1]);
        String result = A + B + "";

        // 特殊的情况直接输出
        if (result.length() <= 3) {
            System.out.println(result);
        }else {
            int length = result.length();
            if (result.charAt(0) == '-') {
                length--;
            }
            // 计算当前的sum要执行次数
            int iterateCount = length / 3;
            int separateIndex ;
            for (int i = 0; i < iterateCount; i++) {
                // 计算要分割的位置：逗号个数 + 循环次数 * 3
                separateIndex = result.length() - SEPARATE * (i + 1) - i;
                // 判断分割的前一个字符是不是 "-" 号
                char flag = result.charAt(separateIndex - 1);
                if (MINUS == flag) {
                    break;
                }else {
                    result = result.substring(0, separateIndex) + "," + result.substring(separateIndex, result.length());
                }
            }
            System.out.println(result);

        }
    }

}