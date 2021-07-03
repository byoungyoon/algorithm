package basic;

// Leetcode
// Palindrome Number
// https://leetcode.com/problems/palindrome-number/

public class basic30 {
    public static void main(String[] args){
        int x = -121;

        if(x < 0) System.out.println(false);

        int sol = 0;
        int copyX = x;
        while(copyX != 0){
            sol += copyX % 10;
            int source = sol;

            copyX = copyX / 10;

            if(copyX != 0){
                sol = sol * 10;
                if (sol / 10 != source) {
                    System.out.println(0);
                }
            }
        }

        System.out.println(sol + " " + x);

        if(x == sol) System.out.println(true);
        else System.out.println(false);
    }
}
