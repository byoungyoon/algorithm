package rescue;

// 프로그래머스
// 문자열 압축

public class resuce3{
    public static void main(String[] args){
        String s = "xxxxxxxxxxqwertyuiopasdfghjkkkkkkkkkk";
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i<s.length()/2 + 1; i++){
            answer = Math.min(answer, extrusion(s, i));
        }

        System.out.println(answer==Integer.MAX_VALUE? 1: answer);
    }

    static int extrusion(String s, int index){
        int count = s.length();
        String[] sArray = s.split("(?<=\\G.{" + index + "})");
        
        boolean check = false;

        int compare = 0;
        int compareSum = 1;
        for(int i=1; i<sArray.length; i++){
            if(sArray[i].equals(sArray[i-1])){
                if(!check){
                    compare = 2;
                    compareSum = 1;
                    check = true;
                    count = count - sArray[i].length() + 1;
                } else {
                    compare ++;
                    if(Math.pow(10, compareSum) == compare){
                        compareSum++;
                        count++;
                    }

                    count = count - sArray[i].length();
                }
            } else{
                check = false;
            }
        }

        return count;
    }
}