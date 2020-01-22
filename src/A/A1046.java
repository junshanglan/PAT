package A;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ：junshanglan
 * @date ：Created in 2020/1/15 22:09
 * @description：
 */
public class A1046 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> collect = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
        collect.remove(0);

        int count = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            List<Integer> data = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
            List<Integer> result = new ArrayList<>();
            Integer begin = data.get(0);
            Integer end = data.get(1);
            if (begin < end) {
                sequence(collect,result,begin,end);
                reverse(collect,result,end,begin);
            }

            if (begin > end) {
                reverse(collect,result,begin,end);
                sequence(collect,result,end,begin);
            }
            System.out.println(Collections.min(result));
        }
    }

    private static void reverse(List<Integer> collect,List<Integer> result,Integer begin,Integer end){
        Integer sum = 0;
        for (int j = begin; j <= collect.size();j++) {
            sum += collect.get(j - 1);
        }
        for (int j = 0; j < end -1; j++) {
            sum += collect.get(j);
        }
        result.add(sum);
    }

    private static void sequence(List<Integer> collect,List<Integer> result,Integer begin,Integer end){
        Integer sum = 0;
        for (int j = begin; j < end; j++) {
            sum += collect.get(j - 1);
        }
        result.add(sum);
    }
}