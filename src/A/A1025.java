package  A;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @author ：junshanglan
 * @date ：Created in 2019/12/29 9:34
 * @description：
 */
public class A1025 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer testLocation= Integer.valueOf(scanner.nextLine());

        List<Student> studentList = new ArrayList<>();
        for (int location = 1; location <= testLocation; location++) {
            List<Student> groupStudentList = new ArrayList<>();
            int count = Integer.valueOf(scanner.nextLine());
            for (int j = 0; j < count; j++) {
                String[] studentInfo = scanner.nextLine().split(" ");
                Student student = new Student(location,studentInfo[0],Integer.valueOf(studentInfo[1]));
                groupStudentList.add(student);
            }

            // 对该分组内的元素进行排序
            groupStudentList = groupStudentList.stream().sorted(Comparator.comparing(Student::getScore).reversed()).collect(toList());

            for (int i = 1; i <= groupStudentList.size(); i++) {
                if (i == 1) {
                    groupStudentList.get(i - 1).setLocalRank(i);
                }else {
                    if (groupStudentList.get(i - 1).getScore() == groupStudentList.get(i -2 ).getScore()) {
                        groupStudentList.get(i - 1).setLocalRank(groupStudentList.get(i - 2).getLocalRank());
                    } else{
                        groupStudentList.get(i -1).setLocalRank(i);
                    }
                }
            }
            studentList.addAll(groupStudentList);
        }

        studentList = studentList.stream().sorted(Comparator.comparing(Student::getScore).reversed()).collect(Collectors.toList());

        for (int i = 1; i <= studentList.size(); i++) {
            if (i == 1) {
                studentList.get(i - 1).setFinalRank(i);
            }else {
                if (studentList.get(i - 1).getScore() == studentList.get(i -2 ).getScore()) {
                    studentList.get(i - 1).setFinalRank(studentList.get(i - 2).getFinalRank());
                } else{
                    studentList.get(i -1).setFinalRank(i);
                }
            }
        }

        for (int i = 0; i < studentList.size(); i++) {
            if (i == 0) {
                System.out.println(studentList.size());
            }
            System.out.println(studentList.get(i).toString());
        }

    }
}



class Student implements Comparable{

    /**
     * 考场号
     */
    private Integer testLocation;

    /**
     * 学号
     */
    private String number;

    /**
     * 分数
     */
    private Integer score;

    /**
     * 排名
     */
    private Integer LocalRank ;

    private Integer finalRank;

    @Override
    public String toString() {
        // registration_number final_rank location_number local_rank
        return number + " " + finalRank + " " + testLocation + " " + LocalRank;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public Integer getTestLocation() {
        return testLocation;
    }

    public void setTestLocation(Integer testLocation) {
        this.testLocation = testLocation;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getLocalRank() {
        return LocalRank;
    }

    public void setLocalRank(Integer localRank) {
        LocalRank = localRank;
    }

    public Integer getFinalRank() {
        return finalRank;
    }

    public void setFinalRank(Integer finalRank) {
        this.finalRank = finalRank;
    }



    public Student(Integer testLocation, String number, Integer score) {
        this.testLocation = testLocation;
        this.number = number;
        this.score = score;
    }
}
