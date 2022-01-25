package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hash20 {
    public static void main(String[] args) {
        int n = 3;
        String[] words = { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" };

        Hash20 hash = new Hash20();
        System.out.println(Arrays.toString(hash.solution(n, words)));
    }

    public int[] solution(int n, String[] words) {
        Map<String, Integer> hm = new HashMap<>();

        int[] answer = new int[2];

        char last = words[0].charAt(0);
        for (int i = 0; i < words.length; i++) {
            if (hm.get(words[i]) != null) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            hm.put(words[i], 0);

            if (last != words[i].charAt(0)) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            last = words[i].charAt(words[i].length() - 1);
        }

        return answer;
    }
}
