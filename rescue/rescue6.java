package rescue;

// 프로그래머스
// 키패드 누르기

public class rescue6 {
    public static void main(String[] args){
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        
        int[][] location = {{1,1,1}, {2,1,2}, {3,1,3}, {4,2,1}, {5,2,2}, {6,2,3}, {7,3,1}, {8,3,2}, {9,3,3}, {-10,4,1}, {0,4,2}, {10,4,3}};
        String answer = "";

        int left = -10;
        int right = 10;

        for(int i: numbers){
            boolean center = false;
            if(i == 0){
                center = true;
            } else{
                switch(i % 3){
                    case 0:
                        answer = answer + "R";
                        right = i;
                        break;
                    case 1:
                        answer = answer + "L";
                        left = i;
                        break;
                    default:
                        center = true;
                        break; 
                }
            }

            if(center){
                int y = 0;
                int x = 0;
                int leftY = 0;
                int leftX = 0;
                int rightY = 0;
                int rightX = 0;
                for(int j=0; j<location.length; j++){
                    if(location[j][0] == i){
                        y = location[j][1];
                        x = location[j][2];
                    }

                    if(location[j][0] == left){
                        leftY = location[j][1];
                        leftX = location[j][2];
                    }

                    if(location[j][0] == right){
                        rightY = location[j][1];
                        rightX = location[j][2];
                    }
                }

                int leftDistance = Math.abs(leftX - x) + Math.abs(leftY - y);
                int rightDistance = Math.abs(rightX - x) + Math.abs(rightY - y);

                if(leftDistance > rightDistance){
                    answer = answer + "R";
                    right = i;
                } else if(leftDistance < rightDistance){
                    answer = answer + "L";
                    left = i;
                } else{
                    if(hand.equals("right")){
                        answer = answer + "R";
                        right = i;
                    } else{
                        answer = answer + "L";
                        left = i;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}