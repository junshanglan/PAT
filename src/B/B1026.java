package B;

import java.util.Scanner;

/**
 * @author ：junshanglan
 * @date ：Created in 2019/12/31 11:11
 * @description：程序运行时间
 */
public class B1026 {

    private static final Integer CLK_TCK = 100;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Float begin = scanner.nextFloat();
        Float end= scanner.nextFloat();

        int diff = Math.round((end - begin)  / CLK_TCK);
        int hour = diff / 3600;
        int minute = diff % 3600 / 60;
        int second = diff % 60;

        System.out.printf("%d:%d:%d",hour,minute,second);


    }

}