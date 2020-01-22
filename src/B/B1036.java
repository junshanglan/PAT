package B;

import java.util.Scanner;

/**
 * @author ：junshanglan
 * @date ：Created in 2019/12/29 11:14
 * @description：
 */
public class B1036 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rowCount = input.nextInt();
        int columnCount = (int) Math.round(new Double(rowCount) / 2);
        String str = input.next();

        for (int i = 0; i < columnCount; i++) {
            for (int j = 0; j < rowCount; j++) {
                if (i == 0 ||i == columnCount - 1)
                    System.out.print(str);
                else{
                    if (j == 0 || j == rowCount -1)
                        System.out.print(str);
                    else
                        System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}