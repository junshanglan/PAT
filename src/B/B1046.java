package B;

import java.util.Scanner;

/**
 * @author ：junshanglan
 * @date ：Created in 2019/12/31 11:48
 * @description：
 */
public class B1046 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer num = Integer.valueOf(scanner.nextLine());
        Integer aDrink = 0;
        Integer bDrink = 0;
        for (int i = 0; i < num; i++) {
            String[] sample = scanner.nextLine().split(" ");
            Integer aCall = Integer.valueOf(sample[0]);
            Integer bCall = Integer.valueOf(sample[2]);
            Integer aFinger = Integer.valueOf(sample[1]);
            Integer bFinger = Integer.valueOf(sample[3]);

            Integer totalCall = aCall + bCall;
            if (aFinger != totalCall && bFinger != totalCall || aFinger == totalCall && bFinger ==totalCall){ }
            if (aFinger == totalCall && bFinger != totalCall)
                bDrink++;
            if (aFinger != totalCall && bFinger == totalCall) {
                aDrink++;
            }
        }
        System.out.println(aDrink +" "+ bDrink);
    }

}