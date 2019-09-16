package B;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B1004 {

    public static void main(String[] args) {
        /**
         * Joe Math990112 89
         * Mike CS991301 100
         * Mary EE990830 95
         */
        Scanner sc1  = new Scanner(System.in);
        int count = sc1.nextInt();
        // 初始化学生信息
        String[] student = new String[count];
        for (int i = 0; i < count; i++) {
            Scanner sc2 = new Scanner(System.in);
            String info = sc2.nextLine();
            student[i] = info;
        }
        // 提取学生成绩
        Map<Integer,Integer> gradeMap = new HashMap<>();
        int[] gradeArr = new int[count];
        for (int i = 0; i < student.length; i++) {
            String one = student[i];
            Integer grade = Integer.valueOf(one.split(" ")[2]);
            gradeArr[i] = grade;
            gradeMap.put(grade,i);
        }
        // 进行排序
        Arrays.sort(gradeArr);
        String[] highest = student[gradeMap.get(gradeArr[count-1])].split(" ");
        String[] lowest =  student[gradeMap.get(gradeArr[0])].split(" ");

        System.out.println(highest[0] + " " + highest[1]);
        System.out.println(lowest[0] + " " + lowest[1]);
    }
}
