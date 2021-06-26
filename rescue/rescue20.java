package rescue;

import java.util.Stack;

// Leetcode
// Valid Parentheses
// https://leetcode.com/problems/valid-parentheses/

public class rescue20 {
    public static void main(String[] args){
        String s = "(})";

        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(st.empty()) st.add(s.charAt(i));
            else{
                switch(s.charAt(i)){
                    case ')':
                        if(st.peek() == '(') st.pop();
                        else System.out.println(false);
                        break;
                    case ']':
                        if(st.peek() == '[') st.pop();
                        else System.out.println(false);
                        break;
                    case '}':
                        if(st.peek() == '{') st.pop();
                        else System.out.println(false);
                        break;
                    default:
                        st.add(s.charAt(i));
                        break;
                }
            }
        }

        if(st.size() != 0) System.out.println(false);

        System.out.println(true);
    }
}
