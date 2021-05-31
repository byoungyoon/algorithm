package basic;

// 프로그래머스
// 문자열 다루기 기본

public class basic17 {
    public static void main(String[] args){
        String s = "11234";

        System.out.println((s.length() == 6 || s.length() == 4) && s.replaceAll("[^0-9]", "").length() == s.length()?true:false);
    }
}
