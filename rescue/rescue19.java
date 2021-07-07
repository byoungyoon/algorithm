package rescue;

import java.util.Stack;

// Leetcode
// Score of Parentheses
// https://leetcode.com/problems/score-of-parentheses/

public class rescue19 {
    public static void main(String[] args){
        String s = "()";

        Stack<Character> st = new Stack<>();
        st.add(s.charAt(0));

        int answer = 0;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == ')' && s.charAt(i-1) == '('){
                answer += Math.pow(2, st.size()-1);
                st.pop();
            } else{
                if(s.charAt(i) == ')'){
                    st.pop();
                } else{
                    st.add(s.charAt(i));
                }
            }
        }

        System.out.println(answer);
    }
}
