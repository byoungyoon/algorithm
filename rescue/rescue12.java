package rescue;

// 프로그래머스
// 정수 삼각형

public class rescue12 {
    static int answer = 0;
    public static void main(String[] args){
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        
        int[][] result = new int[triangle.length][triangle.length];
        result[0][0] = triangle[0][0];

        dp(triangle, result, 1);

        for(int i=0; i<result.length; i++){
            if(answer < result[triangle.length-1][i]){
                answer = result[triangle.length-1][i];
            }
        }

        System.out.println(answer);
    }

    static void dp(int[][] triangle, int[][] result, int depth){
        if(depth == triangle.length){
            return;
        }

        for(int i=0; i<triangle[depth].length-1; i++){
            result[depth][i] = triangle[depth][i] + result[depth-1][i] > result[depth][i] ? triangle[depth][i] + result[depth-1][i] : result[depth][i];
            result[depth][i+1] = triangle[depth][i+1] + result[depth-1][i] > result[depth][i+1] ? triangle[depth][i+1] + result[depth-1][i] : result[depth][i+1];
        }

        dp(triangle,result,depth+1);
    }   
}
