package B;

import java.util.Scanner;

/**
 * @author ：junshanglan
 * @date ：Created in 2020/1/6 22:05
 * @description：
 */
public class B1018 {


    /**
     * 核心：在于比较两个人手势的大小
     * -> 转为数字进行比较
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count= Integer.valueOf(scanner.nextLine());
        // 甲乙胜负次数
        int[] aTime = new int[3];
        int[] bTime = new int[3];
        // 甲乙胜负的手势
        int[] aHand = new int[3];
        int[] bHand = new int[3];

        String[] charArr = new String[]{"B","C","J"};


        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split(" ");
            int aValue = charToInt(input[0]);
            int bValue = charToInt(input[1]);
            // 甲大
            if ((aValue + 1) % 3 == bValue) {
                aTime[0]++;
                bTime[2]++;
                aHand[aValue]++;
            }else if (aValue % 3 == bValue) { // 平局
                aTime[1]++;
                bTime[1]++;
            }else{ // 乙大
                aTime[2]++;
                bTime[0]++;
                bHand[bValue]++;
            }
        }
        int aMax = 0;
        int bMax = 0;

        for (int i = 0; i < 2; i++) {
            if (aHand[i + 1] > aHand[aMax]) aMax = i;

            if (bHand[i + 1] > bHand[bMax]) bMax = i;
        }

        System.out.println(aTime[0]+" " + aTime[1] + " " + aTime[2]);
        System.out.println(bTime[0]+" " + bTime[1] + " " + bTime[2]);
        System.out.println(charArr[aMax] +" "+ charArr[bMax]);

    }

    private static int charToInt(String s){
        if (s.equals("B")) return 0;
        if (s.equals("C")) return 1;
        if (s.equals("J")) return 2;
        return 0;
    }
}