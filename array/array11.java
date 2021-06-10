package array;

// 프로그래머스
// [1차] 추석 트래픽

public class array11 {
    public static void main(String[] args){
        String[] lines = {"2016-09-15 20:59:57.421 0.351s",
                            "2016-09-15 20:59:58.233 1.181s",
                            "2016-09-15 20:59:58.299 0.8s",
                            "2016-09-15 20:59:58.688 1.041s",
                            "2016-09-15 20:59:59.591 1.412s",
                            "2016-09-15 21:00:00.464 1.466s",
                            "2016-09-15 21:00:00.741 1.581s",
                            "2016-09-15 21:00:00.748 2.31s",
                            "2016-09-15 21:00:00.966 0.381s",
                            "2016-09-15 21:00:02.066 2.62s"
                        };

        // String[] lines = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
        
        int[][] location = new int[lines.length][2]; 

        for(int i=0; i<lines.length; i++){
            String[] split = lines[i].split(" ");

            String[] timeSplit = split[1].split(":|\\.");
            int hour = Integer.parseInt(timeSplit[0]);
            int min = Integer.parseInt(timeSplit[1]);
            int second = (hour*60*60 + min*60 + Integer.parseInt(timeSplit[2]))*1000;
            int mills = Integer.parseInt(timeSplit[3]);
            Float addMills = Float.parseFloat(split[2].substring(0, split[2].length()-1));

            int end = second+mills;
            int start = end - (int)(addMills*1000) + 1;

            location[i][0] = start;
            location[i][1] = end;
        }

        int answer = 0;

        for(int i=0; i<location.length; i++){
            for(int j=0; j<2; j++){
                int point = location[i][j];
                int count = 0;
                for(int z=0; z<location.length; z++){
                    int start = location[z][0];
                    int end = location[z][1];
                    if(start <= point && end >= point) count++;
                    else if(start <= point+999 && end >= point+1000) count++;
                    else if(start > point && end < point+1000) count++;
                }
                answer = answer > count ? answer : count;
            }
        }

        System.out.println(answer);
    }   

}
