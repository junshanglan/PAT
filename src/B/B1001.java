package B;

import java.util.Scanner;

/**
 * @author ：junshanglan
 * @date ：Created in 2019/12/29 10:49
 * @description：
 */
public class B1001 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int count = 0;
        while (n != 1) {
            if (n % 2 == 0 ) {
                n = n / 2;
            }else {
                n = (3*n + 1) / 2;
            }
            count++;
        }

        System.out.println(count);


    }

}