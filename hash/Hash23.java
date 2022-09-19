package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/77486

public class Hash23 {
    public static void main(String[] args) {
        String[] enroll = { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" };
        String[] referral = { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" };
        String[] seller = { "young", "john", "tod", "emily", "mary" };
        int[] amount = { 12, 4, 2, 5, 10 };

        Hash23 test = new Hash23();
        System.out.println(Arrays.toString(test.solution(enroll, referral, seller, amount)));
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Node> hm = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            hm.put(enroll[i], new Node(referral[i], 0));
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < seller.length; i++) {
            String tName = seller[i];
            int tAmount = amount[i] * 100;
            while (true) {
                Node node = hm.get(tName);
                node.modAmount(tAmount - (tAmount / 10));

                tName = node.name;
                tAmount = tAmount / 10;

                if (tName.equals("-") || tAmount <= 0)
                    break;
            }
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = hm.get(enroll[i]).amount;
        }

        return answer;
    }

    class Node {
        String name;
        int amount;

        public Node(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }

        public void modAmount(int amount) {
            this.amount += amount;
        }
    }
}
