package dfs.bfs;

import java.util.ArrayList;
import java.util.List;

// Leetcode
// Generate Parentheses
// https://leetcode.com/problems/generate-parentheses/

public class dfs2 {
    static List<String> answer;
    public dfs2(){
        answer = null;
    }
    public static void main(String[] args){
        int n = 3;

        answer = new ArrayList<>();
        dfs("", 0, 0, n);

        System.out.println(answer);
    }

    static void dfs(String value, int left, int right, int n){
        if(n == left && right == left){
            answer.add(value);
            return;
        }

        if(left > n || right > n) return;

        dfs(value+"(", left+1, right, n);
        
        if(left > right){
            dfs(value+")", left, right+1, n);
        }
    }
}
