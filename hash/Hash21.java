package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hash21 {
    public static void main(String[] args) {
        String msg = "KAKAO";

        Hash21 test = new Hash21();
        System.out.println(Arrays.toString(test.solution(msg)));
    }

    private int[] solution(String msg) {
        Map<String, Integer> hm = new HashMap<>();
        onDefault(hm);

        List<Integer> answer = new ArrayList<>();

        int lastCount = hm.size() + 1;

        int index = 0;
        String str = "";
        String lastStr = "";

        while (index < msg.length()) {
            int firstIndex = index;
            while (true) {
                if (index >= msg.length())
                    break;
                index++;
                str = msg.substring(firstIndex, index);

                if (hm.get(str) == null) {
                    index--;
                    break;
                }
                lastStr = str;
            }
            answer.add(hm.get(lastStr));
            hm.put(str, lastCount);
            lastCount++;
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private Map<String, Integer> onDefault(Map<String, Integer> hm) {
        String[] example = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
                "S", "T", "U", "V", "W", "X", "Y", "Z" };
        for (int i = 1; i <= example.length; i++) {
            hm.put(example[i - 1], i);
        }
        return hm;
    }
}