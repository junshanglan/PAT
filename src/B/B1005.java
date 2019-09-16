package B;


import java.util.*;

public class B1005 {

    public static void main(String[] args) {
        /**
         * 6
         * 3 5 6 7 8 11
         */
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        Scanner sc1 = new Scanner(System.in);
        String n = sc1.nextLine();

        String[] s = n.split(" ");
        Set<Integer> processNum = new HashSet<>();
        for (int i = 0; i < s.length; i++) {
            int temp = Integer.valueOf(s[i]);
            while (temp != 1) {
                if (temp % 2 == 0) {
                    temp = temp / 2;
                    processNum.add(temp);
                }else {
                    temp = (3* temp + 1) /2;
                    processNum.add(temp);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            if (!processNum.contains(Integer.valueOf(s[i]))) {
                result.add(Integer.valueOf(s[i]));
            }
        }

        Collections.reverse(result);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.size(); i++) {
            if (i != result.size() -1) {
                sb.append(result.get(i)).append(" ");
            }else{
                sb.append(result.get(i));
            }
        }
        System.out.println(sb);

    }



}