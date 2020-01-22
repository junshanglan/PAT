package B;

import java.util.Scanner;

/**
 * @author ：junshanglan
 * @date ：Created in 2019/12/31 15:03
 * @description：数组元素循环右移问题
 */
public class B1008 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] countAndMove = scanner.nextLine().split(" ");
        int count = Integer.parseInt(countAndMove[0]);
        int move = Integer.parseInt(countAndMove[1]) % count;

        String[] element = scanner.nextLine().split(" ");
        for (int i = element.length - move; i < element.length; i++) {
            System.out.print(element[i] + " ");
        }

        for (int i = 0; i < element.length - move; i++) {
            String separator = " ";
            if (i == element.length - move -1) {
                separator = "";
            }
            System.out.print(element[i] + separator);
        }



    }
}

