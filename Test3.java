public class Test3 {
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args){
        int n = 16;
        dp(n, 1, true, 0);

        System.out.println(answer);
    }

    static void dp(int n, int current, boolean check, int count){
        if(current > n) return;
        if(current == n){
            answer = answer > count ? count : answer;
            return;
        }

        if(check){
            dp(n, current + 2, !check, count+1);
        }
        dp(n, current + 1, !check, count+1);
        check = true;
    }
}
