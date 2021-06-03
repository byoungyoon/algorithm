package rescue;

import java.util.Stack;

// 프로그래머스
// 괄호 회전하기

public class rescue7 {
    public static void main(String[] args){
        String s = "}]()[{";

        char[][] judgment = {{'[',']'},{'(',')'},{'{','}'}};
        int answer = 0;
        
        for(int a=0; a<s.length(); a++){
            Stack<Character> st = new Stack<>();
            for(int i=0; i<s.length(); i++){
                if(i==0){
                    st.push(s.charAt(i));
                    continue;
                }
                define(s.charAt(i), judgment, st);
            }

            if(st.empty()) answer = answer + 1;
            s = s.substring(1) + String.valueOf(s.charAt(0));
        }

        System.out.println(answer);
    }    

    static void define(char value, char[][] judgment, Stack<Character> st){
        for(int i=0; i<3; i++){
            if(value == judgment[i][1]){
                if(st.empty()){
                    st.push(value);
                    return;
                }
                if(st.peek() == judgment[i][0]){
                    st.pop();
                } else{
                    st.push(value);
                }
                return;
            } else if(value == judgment[i][0]){
                st.push(value);
            }
        }
    }
}
