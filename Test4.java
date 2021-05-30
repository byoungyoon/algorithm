import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test4 {
    public static void main(String[] args){
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        List<Integer> answer = new ArrayList<>();
        
        for(String s: query){
            String[] queryArray = s.replaceAll("and ", "").split(" ");
            int count = Integer.parseInt(queryArray[queryArray.length-1]);

            List<String> infoList = Arrays.stream(info).collect(Collectors.toList());
            for(int i=0; i<queryArray.length; i++){
                if(queryArray[i].equals("-")) continue;
                if(i == queryArray.length-1){
                    
                } else{
                    //infoList = infoList.stream().filter(data-> data.indexOf(ss) != -1).collect(Collectors.toList());
                }
            }

            infoList = infoList.stream().filter(data-> Integer.parseInt(data.split(" ")[4]) >= count).collect(Collectors.toList());

            answer.add(infoList.size());
        }

        System.out.println(answer);
    }
}
