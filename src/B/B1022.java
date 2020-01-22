package B;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：junshanglan
 * @date ：Created in 2019/12/29 11:43
 * @description：
 */
public class B1022 {

    public static void main(String[] args) {
        // 123 456 8  579
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int format = input.nextInt();
        int sum = a + b;

        List<Integer> resultList = new ArrayList<>();
        while (sum != 0) {
            int res = sum % format;
            sum = sum / format;
            resultList.add(res);
        }
        StringBuffer result = new StringBuffer();
        Collections.reverse(resultList);
        for (Integer one: resultList) {
            result.append(one);
        }
        String string = result.toString();
        if ("".equals(string))
            string = "0";
        System.out.println(string);
    }
}

