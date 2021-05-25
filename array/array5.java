package array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// 프로그래머스
// 튜플

public class array5 {
    public static void main(String[] args){
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

        Pattern pattern = Pattern.compile("[{](.*?)[}]");
        Matcher matcher = pattern.matcher(s.substring(1, s.length()-1));

        List<String> list = new ArrayList<>();

        while(matcher.find()){
            list.add(matcher.group(1));

            if(matcher.group(1) == null){
                break;
            }
        }

        Collections.sort(list, (a,b)-> a.length() - b.length());

        List<Integer> answer = new ArrayList<>();
        answer.add(Integer.parseInt(list.get(0)));
        for(int i=1; i<list.size(); i++){
            List<Integer> check = Arrays.stream(list.get(i).split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
            for(int j=0; j<i; j++){
                check.remove(answer.get(j));
            }
            answer.add(check.get(0));
        }

        System.out.println(answer);
    }
}
