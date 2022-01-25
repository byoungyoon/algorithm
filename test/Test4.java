public class Test4 {
    static int[][] direction = {{0,1}, {1,0}};
    public static void main(String[] args){
        int m = 3;
        int n = 3;
        // int[][] cityMap = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
        int[][] cityMap = {{0,0,0}, {0,0,0}, {0,0,0}};

        int[][] route = new int[m][n];
        route[0][0] = 1;
        dp(cityMap, route, 0, 0, 0, 0);

        for(int i=0; i<route.length; i++){
            for(int j=0; j<route[0].length; j++){
                System.out.print(cityMap[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for(int i=0; i<route.length; i++){
            for(int j=0; j<route[0].length; j++){
                System.out.print(route[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(route[m-1][n-1]);
    }

    static void dp(int[][] cityMap, int[][] route, int x, int y, int preX, int preY){
        if(x == cityMap[0].length-1 && y == cityMap.length-1) return;

        for(int i=0; i<direction.length; i++){
            int nextX = x + direction[i][1];
            int nextY = y + direction[i][0];

            if(nextX >= cityMap[0].length || nextY >= cityMap.length) continue;
            if(cityMap[nextY][nextX] == 1) continue;
            else{
                if(cityMap[y][x] == 2){
                    if(Math.abs(nextX - preX) - Math.abs(nextY - preY) == 0) continue;
                    dp(cityMap, route, nextX, nextY, x, y);
                } else{
                    route[nextY][nextX] += route[y][x];
                    System.out.println(route[y][x] + "  " + y + " " + x + " : " + nextY + " " + nextX);
                    dp(cityMap, route, nextX, nextY, x, y);
                }
            }
        }
    }
}
