package rescue;

import java.util.Arrays;

// 프로그래머스
// 시저암호

public class rescue2 {
    public static void main(String[] args){
        String s = "a b  ";
        int n = 25;

        String answer = Arrays.stream(s.split("")).reduce("", (a,b)->{
            if(b.equals(" ")) return a+b;
            else{
                int value = (int)b.charAt(0);
                if(value > 64 && value < 91){
                    value = value + n;
                    if(value > 90) value = value - 26;
                } else{
                    value = value + n;
                    if(value > 122) value = value - 26;
                }
                return a + (char)value;
            }
        });

        System.out.println(answer);
    }
}
