import java.util.ArrayList;
import java.util.List;

public class Test6 {
    public static void main(String[] args){
        int[][] lend = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};

        boolean[] visited = new boolean[lend[0].length];
        List<Integer> list = new ArrayList<>();
        backtracking(lend, visited, list, 0);
    }

    static void backtracking(int[][] lend, boolean[] visited, List<Integer> list, int depth){
        if(depth == lend.length){
            System.out.println(list);

            return;
        }
        
        for(int i=0; i<lend[0].length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            list.add(lend[depth][i]);
            backtracking(lend, visited, list, depth+1);
            // list.remove(l);
            visited[i] = false;
        }
    }
}
