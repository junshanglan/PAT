package B;

import java.util.Scanner;

public class B1002 {

    public static void main(String[] args) {
        //1234567890987654321123456789
        String[] chineseNum = {"ling","yi","er","san","si","wu","liu","qi","ba","jiu","shi"};
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] numChar = s.toCharArray();
        Integer sum = 0;
        for (int i = 0; i < numChar.length; i++) {
            int temp = Integer.parseInt(String.valueOf(numChar[i]));
            sum += temp;
        }
        StringBuffer result = new StringBuffer();
        char[] resultChar = sum.toString().toCharArray();
        for (int i = 0; i < resultChar.length; i++) {
            int temp = Integer.parseInt(String.valueOf(resultChar[i]));
            if (i != resultChar.length-1) {
                result.append(chineseNum[temp]).append(" ");
            }else{
                result.append(chineseNum[temp]);
            }
        }
        System.out.println(result);

    }
}
