package B;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：junshanglan
 * @date ：Created in 2019/12/31 11:09
 * @description：德才论
 */
public class B1015 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        Integer total = Integer.valueOf(input[0]);
        Integer low = Integer.valueOf(input[1]);
        Integer priority = Integer.valueOf(input[2]);

        List<Student01> studentList = new ArrayList<>();
        List<Student01> moralAndTalent = new ArrayList<>();
        List<Student01> moralMoreThanTalent = new ArrayList<>();
        List<Student01> noMoralAndTalent = new ArrayList<>();
        List<Student01> lowest = new ArrayList<>();
        for (int i = 1; i <= total; i++) {
            String[] studentInfo = scanner.nextLine().split(" ");
            Integer moralScore = Integer.valueOf(studentInfo[1]);
            Integer talentScore = Integer.valueOf(studentInfo[2]);

            Student01 student01 = new Student01(studentInfo[0], moralScore, talentScore);
            // 才德全尽
            if (moralScore >= priority && talentScore >= priority) {
                moralAndTalent.add(student01);
            }else if (moralScore >= priority && talentScore < 80 && talentScore >= low) { // 德胜才
                moralMoreThanTalent.add(student01);
            }else if (moralScore < priority && moralScore >= low && talentScore <priority && talentScore >= low && moralScore > talentScore ) {// 才德兼亡”但尚有“德胜才”者
                noMoralAndTalent.add(student01);
            }else if(moralScore >= low && talentScore >= low){
                lowest.add(student01);
            }
        }

        Collections.sort(moralAndTalent);
        Collections.sort(moralMoreThanTalent);
        Collections.sort(noMoralAndTalent);
        Collections.sort(lowest);

        studentList.addAll(moralAndTalent);
        studentList.addAll(moralMoreThanTalent);
        studentList.addAll(noMoralAndTalent);
        studentList.addAll(lowest);

        System.out.println(studentList.size());
        studentList.forEach(v -> System.out.println(v.toString()));

    }
}

class Student01 implements Comparable<Student01>{

    private String number;

    private Integer talent;

    private Integer moral;

    private Integer total;

    @Override
    public int compareTo(Student01 o) {
        // 当某类考生中有多人总分相同时，按其德分降序排列；若德分也并列，则按准考证号的升序输出。
        if (!this.total.equals(o.getTotal())){
            return -(this.total - o.getTotal());
        }else {
            if (!this.moral.equals(o.getMoral())) {
                return - (this.moral - o.getMoral());
            }else{
                return this.number.compareTo(o.getNumber());
            }
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getTalent() {
        return talent;
    }

    public void setTalent(Integer talent) {
        this.talent = talent;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getMoral() {
        return moral;
    }

    public void setMoral(Integer moral) {
        this.moral = moral;
    }

    public Student01(String number, Integer moral, Integer talent) {
        this.number = number;
        this.moral = moral;
        this.talent = talent;
        this.total = talent + moral;

    }

    @Override
    public String toString() {
        return number + " " + moral + " " + talent;
    }
}