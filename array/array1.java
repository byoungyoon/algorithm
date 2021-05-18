package array;

// 프로그래머스
// 행렬의 덧셈

public class array1 {
    public static void main(String[] args){
        int[][] arr1 = {{1,2}, {2,3}};
        int[][] arr2 = {{3,4}, {5,6}};

        int[][] answer = new int[arr1.length][arr1[0].length];

        for(int i=0; i<answer.length; i++){
            for(int j=0; j<answer[0].length; j++){
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        System.out.println(answer);
    }
}
