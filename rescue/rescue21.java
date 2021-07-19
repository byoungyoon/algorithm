package rescue;

// Leetcode
// Remove Outermost Parentheses
// https://leetcode.com/problems/remove-outermost-parentheses/

public class rescue21 {
    public static void main(String[] args){
        String s = "()()";

        StringBuilder answer = new StringBuilder();

        int count = 0;
        int index = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') count++;
            else count--;

            if(count == 0){
                answer.insert(answer.length(), s.substring(index+1, i));
                index = i+1;
            }
        }

        System.out.println(answer.toString());
    }
}
