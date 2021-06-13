package dp;

import java.util.ArrayList;
import java.util.List;

// Leetcode
// Remove Invalid Parentheses
// https://leetcode.com/problems/remove-invalid-parentheses/

class dp2 {
    public static void main(String[] args){
        String s = "()())()";

        dp2 test = new dp2();
        System.out.println(test.removeInvalidParentheses(s));
    }

    public List<String> removeInvalidParentheses(String s){
        List<String> answer = new ArrayList<>();
        helper(s, answer, 0, 0, '(', ')');
        return answer;
    }

    public void helper(String s, List<String> answer, int start_i, int start_j, char left, char right){
        int count = 0;
        for(int i=start_i; i<s.length(); i++){
            if(s.charAt(i) == left) count++;
            else if(s.charAt(i) == right) count--;
            
            if(count >= 0) continue;

            for(int j=start_j; j<=i; j++){
                if(s.charAt(j) == right && (start_j == j || s.charAt(j) != s.charAt(j-1))){
                    helper(s.substring(0, j) + s.substring(j+1), answer, i, j, left, right);
                }
            }

            return;
        }

        String reverse = new StringBuilder(s).reverse().toString();
        if(left == '('){
            helper(reverse, answer, 0, 0, ')', '(');
        } else{
            answer.add(reverse);
        }
    }
}
