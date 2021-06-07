package rescue;

import java.util.Stack;

// 프로그래머스
// 올바른 괄호

public class rescue11 {
    public static void main(String[] args){
        String s = "()()";

        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(st.size() != 0){
                if(st.peek() == '(' && s.charAt(i) == ')'){
                    st.pop();
                } else{
                    st.push(s.charAt(i));
                }
            } else{
                st.push(s.charAt(i));
            }

            System.out.println(st);
        }

        System.out.println(st.size()==0);
    }
}
