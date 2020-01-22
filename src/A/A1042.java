package A;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author ：junshanglan
 * @date ：Created in 2020/1/7 22:08
 * @description：
 */
public class A1042 {

    public static void main(String[] args) {

        String[] dataSource = new String[54];
        String[] prefixArr = new String[]{"S","H","C","D"};
        for (int i = 0; i < prefixArr.length; i++) {
            String prefix = prefixArr[i];
            for (int j = 1; j <= 13; j++) {
                String data = prefix + j;
                dataSource[i * 13 + j - 1] = data;
            }
        }
        dataSource[52] = "J1";
        dataSource[53] = "J2";

        Scanner scanner = new Scanner(System.in);
        int count = Integer.valueOf(scanner.nextLine());
        List<Integer> order = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());

        for (int i = 0; i < count; i++) {
            String[] newDataSource = new String[54];
            for (int j = 0; j < order.size(); j++) {
                newDataSource[order.get(j) - 1] = dataSource[j];
            }
            dataSource = newDataSource;
        }

        String string = Arrays.toString(dataSource).replace(",","");
        System.out.println(string.substring(1,string.length() - 1));
    }
}