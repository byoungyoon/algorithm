package array;

public class Array18 {
    public static void main(String[] args) {
        int[][] goods = { { 25400, 2 }, { 10000, 1 }, { 31600, 1 } };
        int[][] coupons = { { 5, 3 }, { 23, 2 }, { 11, 2 }, { 9, 5 } };

        Array18 array = new Array18();
        System.out.println(array.solution(goods, coupons));
    }

    private int solution(int[][] goods, int[][] coupons) {
        goods = bubbleSort(goods);
        coupons = bubbleSort(coupons);

        int answer = 0;

        for (int i = 0; i < goods.length; i++) {
            if (goods[i][1] == 0)
                continue;
            for (int[] coupon : coupons) {
                if (coupon[1] == 0)
                    continue;
                answer += goods[i][0] / 100 * (100 - coupon[0]);
                coupon[1]--;
                goods[i][1]--;
                i = -1;
                break;
            }
        }

        for (int i = 0; i < goods.length; i++) {
            if (goods[i][1] != 0)
                answer += goods[i][0] * goods[i][1];
        }

        return answer;
    }

    private int[][] bubbleSort(int[][] value) {
        for (int i = 0; i < value.length; i++) {
            for (int j = i; j < value.length; j++) {
                if (value[i][0] < value[j][0]) {
                    int[] tmp = value[i];
                    value[i] = value[j];
                    value[j] = tmp;
                }
            }
        }

        return value;
    }
}
