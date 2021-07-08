package array;
import java.util.ArrayList;
import java.util.List;

// 프로그래머스
// 거리두기 확인하기
// https://programmers.co.kr/learn/courses/30/lessons/81302

public class array13 {
    public static void main(String[] args){
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", 
        "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        int[][] oneWay = {{1,0}, {0,1}};
        int[][] twoWay = {{2,0}, {0,2}};
        int[][] threeWay = {{1,1}, {-1,1}};

        List<Integer> answers = new ArrayList<>();

        for(String[] place: places){
            int answer = 1;
            Loop:
            for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    if(place[i].charAt(j) != 'P') continue;
                    
                    for(int z=0; z<oneWay.length; z++){
                        int checkY = i + oneWay[z][1];
                        int checkX = j + oneWay[z][0];

                        if(checkX >= 5 || checkY >= 5) continue;
                        if(place[checkY].charAt(checkX) != 'P') continue;
                            
                        answer = 0;
                        break Loop;
                    }

                    for(int z=0; z<twoWay.length; z++){
                        int checkY = i + twoWay[z][1];
                        int checkX = j + twoWay[z][0];

                        if(checkX >= 5 || checkY >= 5) continue;
                        if(place[checkY].charAt(checkX) != 'P') continue;
                        if(place[checkY - twoWay[z][1]/2].charAt(checkX-twoWay[z][0]/2) == 'X') continue;

                        answer = 0;
                        break Loop;
                    }

                    for(int z=0; z<threeWay.length; z++){
                        int checkY = i + threeWay[z][1];
                        int checkX = j + threeWay[z][0];

                        if(checkX < 0 || checkX >= 5 || checkY >= 5) continue;
                        if(place[checkY].charAt(checkX) != 'P') continue;
                        if(place[checkY - threeWay[z][1]].charAt(checkX) == 'X' && place[checkY].charAt(checkX - threeWay[z][0]) == 'X') continue;

                        answer = 0;
                        break Loop;
                    }
                }
            }
            answers.add(answer);
        }

        System.out.println(answers);
    }
}
