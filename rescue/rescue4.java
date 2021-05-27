package rescue;

// 프로그래머스
// 3진법 뒤집기

public class rescue4 {
    public static void main(String[] args){
        int n = 45;
        
        String threeN = "";
        while(n > 0){
            threeN += n%3;
            n = n / 3;
        }

        String[] threeNArray = threeN.split("");
        int answer = 0;
        for(int i=0; i<threeNArray.length; i++){
            answer += Integer.parseInt(threeNArray[i]) * Math.pow(3, threeNArray.length-i-1);  
        }
        
        System.out.println(answer);
        
    }
}
