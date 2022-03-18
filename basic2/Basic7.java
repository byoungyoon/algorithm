package basic2;

public class Basic7 {
    public static void main(String[] args) {
        int[][] sizes = { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } };

        Basic7 basic = new Basic7();
        System.out.println(basic.solution(sizes));
    }

    public int solution(int[][] sizes) {
        int width = 1000;
        int height = 1000;
        for (int[] size : sizes) {
            if (size[0] > size[1]) {
                width = size[0] > width ? size[0] : width;
                height = size[1] > height ? size[1] : height;
            } else {
                width = size[1] > width ? size[1] : width;
                height = size[0] > height ? size[0] : height;
            }
        }

        int answer = width * height;
        return answer;
    }
}
