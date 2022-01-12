package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Hash17 {
    public static void main(String[] args) {
        String[] record = { "Enter uid1234 Muzi", "Change uid1234 Muzi", "Leave uid1234", "Enter uid1234 Prodo" };

        Hash17 hash = new Hash17();
        System.out.println(hash.solution(record));
    }

    private List<String> solution(String[] record) {
        Map<String, String> map = new HashMap<>();

        List<String> check = new ArrayList<>();

        for (String s : record) {
            StringTokenizer st = new StringTokenizer(s);
            switch (st.nextToken()) {
                case "Enter":
                    String enter = st.nextToken();
                    map.put(enter, st.nextToken());
                    check.add(enter + "-님이 들어왔습니다.");
                    break;
                case "Leave":
                    check.add(st.nextToken() + "-님이 나갔습니다.");
                    break;
                case "Change":
                    map.put(st.nextToken(), st.nextToken());
                    break;
            }
        }

        List<String> answer = new ArrayList<>();

        for (String s : check) {
            StringTokenizer st = new StringTokenizer(s, "-");
            answer.add(map.get(st.nextToken()) + st.nextToken());
        }

        return answer;
    }
}