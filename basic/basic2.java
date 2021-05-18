package basic;

// 프로그래머스
// 핸드폰 번호 가리기

public class basic2 {
    public static void main(String[] args){
        String test = "01033334444";
        System.out.println(test.substring(0,test.length()-4).replaceAll("[0-9]", "*") + test.substring(test.length()-4));
        //System.out.println(test.replaceAll(".(?<=.{4})", "*"));
    }
}
