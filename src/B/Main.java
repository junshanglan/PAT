package B;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Character> checkChar = new ArrayList<Character>();
        checkChar.add('P');
        checkChar.add('A');
        checkChar.add('T');
        checkChar.add(' ');
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        // 成功条件： P:1 T:1 "" 与 "A"不限
        for (int i = 0; i < count; i++) {
            Scanner sc2 = new Scanner(System.in);
            char[] inputChar = sc2.nextLine().toCharArray();
            boolean point = true;
            int PCount = 0;
            int TCount = 0;
            for (int j = 0; j < inputChar.length; j++) {
                if (!checkChar.contains(inputChar[j])) {
                    System.out.println("NO");
                    point = false;
                    break;
                }
                if (inputChar[j] == 'P') {
                    PCount++;
                }
                if (inputChar[j] == 'T') {
                    TCount++;
                }
            }
            if (point == true) {
                if (PCount != 1 || TCount != 1) {
                    System.out.println("NO");
                }else {
                    System.out.println("YES");
                }
            }
        }
    }

}
