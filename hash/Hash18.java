package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Hash18 {
    public static void main(String[] args) {
        String[] id_list = { "muzi", "frodo", "apeach", "neo" };
        String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
        int k = 2;

        Hash18 hash = new Hash18();
        System.out.println(Arrays.stream(hash.solution(id_list, report, k)).boxed().collect(Collectors.toList()));
    }

    private int[] solution(String[] id_list, String[] report, int k) {
        Map<String, HashSet<String>> hm = new HashMap<>();

        for (String s : report) {
            StringTokenizer st = new StringTokenizer(s);
            String id = st.nextToken();
            String rep = st.nextToken();

            HashSet<String> value = hm.get(rep) == null ? new HashSet<>() : hm.get(rep);
            value.add(id);

            hm.put(rep, value);
        }

        int[] answer = new int[id_list.length];
        List<String> idList = Arrays.stream(id_list).collect(Collectors.toList());
        for (String s : hm.keySet()) {
            if (hm.get(s).size() < k)
                continue;

            for (String ss : hm.get(s)) {
                answer[idList.indexOf(ss)]++;
            }
        }

        return answer;
    }
}
