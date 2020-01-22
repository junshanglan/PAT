package B;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：junshanglan
 * @date ：Created in 2019/12/31 15:33
 * @description： 数字分类
 */
public class B1012 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] s = scanner.nextLine().split(" ");
        List<Integer> data = Stream.of(s).map(Integer::valueOf).collect(Collectors.toList());
        int[] result = new int[5];
        int[] count = new int[5];
        data.forEach(e -> {
            int remain = e % 5;
            switch (remain) {
                case 0:
                    if (e % 2 == 0) {
                        result[0] += e;
                        count[0]++;
                    }
                    break;
                case 1:
                    count[1]++;
                    if (count[1] % 2 == 1) {
                        result[1] += e;
                    }else{
                        result[1] -= e;
                    }
                    break;
                case 2:
                    count[2]++;
                    break;
                case 3:
                    result[3] += e;
                    count[3] ++;
                    break;
                case 4:
                    if (e > result[4]) {
                        result[4] = e;
                    }
                    count[4]++;
                    break;
            }
        });

        System.out.print(count[0] == 0? "N ":result[0] + " ");
        System.out.print(count[1] == 0? "N ":result[1] + " ");
        System.out.print(count[2] == 0? "N ":count[2] + " ");
        System.out.print(count[3] == 0? "N ":new BigDecimal(result[3]).divide(new BigDecimal(count[3])).setScale(1,BigDecimal.ROUND_HALF_UP) + " ");
        System.out.print(count[4] == 0? "N":result[4] );





    }
}