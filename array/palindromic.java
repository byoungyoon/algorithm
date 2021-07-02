package array;

// Leetcode
// Longest Palindromic Substring
// https://leetcode.com/problems/longest-palindromic-substring/

public class palindromic {
    public static void main(String[] args){
        String s = "babad";

        int count = s.length()-1;
        while(count != 0){
            for(int i=0; i<s.length()-count; i++){
                String value = checkS(s, i, i+count);
                if(value != null) System.out.println(value);
            }   
            count = count - 1;
        }
    }

    static String checkS(String s, int front, int back){
        boolean even = false;
        if((back - front) % 2 != 0) even = true;

        int frontCheck = front;
        int backCheck = back;

        while(!even ? frontCheck != backCheck : frontCheck < backCheck){
            if(s.charAt(frontCheck) != s.charAt(backCheck)){
                return null;
            }
            frontCheck = frontCheck + 1;
            backCheck = backCheck - 1;
        }
        
        return s.substring(front, back+1);
    }
}
