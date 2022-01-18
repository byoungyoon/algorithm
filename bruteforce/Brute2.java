package bruteforce;

public class Brute2 {
    public static void main(String[] args) {
        int n = 110011;
        int k = 10;

        Brute2 brute = new Brute2();
        System.out.println(brute.solution(n, k));
    }

    private int solution(int n, int k) {
        String numStr = numStr(n, k);

        int answer = 0;
        String str = "";

        for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) == '0') {
                if (str.equals(""))
                    continue;

                if (decimal(Long.parseLong(str)))
                    answer++;
                str = "";
                continue;
            }
            str += numStr.charAt(i);
        }

        if (!str.equals("")) {
            if (decimal(Long.parseLong(str)))
                answer++;
        }

        return answer;
    }

    private String numStr(int n, int k) {
        String result = "";
        while (n > 0) {
            result = (n % k) + result;
            n = n / k;
        }

        return result;
    }

    private boolean decimal(long num) {
        if (num == 1)
            return false;
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

}
