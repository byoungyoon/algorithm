package timeout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Test5 {
    static int answer = 0;
    static int count = 0;

    public static void main(String[] args){
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};

        boolean[] visited = new boolean[user_id.length];

        backtracking(user_id, banned_id, visited, user_id.length, banned_id.length, 0);

        System.out.println(answer);
    }

    static void compare(String[][] detailClassification, String[] banned_id){
        for(String s: banned_id){
            for(int i=0; i<detailClassification.length; i++){
                int same = 0;
                boolean[] visited = new boolean[detailClassification[i].length];
                for(int j=0; j<detailClassification[i].length; j++){
                    if(detailClassification[i][j].length() != s.length()) break;
                    for(int z=0; z<detailClassification[i][j].length(); z++){
                        if(detailClassification[i][j].charAt(z) == '*') same++;
                        else if(detailClassification[i][j].charAt(z) == s.charAt(z)) same++;
                    }
                }
                if(same == s.length()){
                    answer = answer + 1;
                    return;
                }
            }
        }
    }

    static int factorial(int size){
        int result = 1;
        for(int i=1; i<=size; i++){
            result = result * i;
        }
        return result;
    }

    static void relay(String[] classification, String[] banned_id){
        count = 0;
        boolean[] visited = new boolean[classification.length];
        String[][] detailClassification = new String[factorial(classification.length)][classification.length];
        backtracking2(classification, visited, detailClassification, classification.length, 0);
        compare(detailClassification, banned_id);
    }

    static void backtracking2(String[] classification, boolean[] visited, String[][] detailClassification, int n, int depth){
        if(depth == n){
            count = count + 1;
            return;
        }

        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            detailClassification[count][i] = classification[i];
            backtracking2(classification, visited, detailClassification, n, depth+1);
            visited[i] = false;
        }
    }

    static void backtracking(String[] user_id, String[] banned_id, boolean[] visited, int n, int r, int depth){
        if(r == 0){
            AtomicInteger index = new AtomicInteger();
            String[] classification = Arrays.stream(user_id).filter(data-> visited[index.getAndIncrement()]).toArray(String[]::new);
            
            relay(classification, banned_id);

            return; 
        }

        for(int i=depth; i<n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            backtracking(user_id, banned_id, visited, n, r-1, i);
            visited[i] = false;
        }
    }
}
