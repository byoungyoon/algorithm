package rescue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 프로그래머스
// [3차] 파일명 정렬

public class rescue11 {
    public static void main(String[] args){
        String[] files = {"img000012345", "img1.png","img2","IMG02"};

        HashMap<File, Integer> hm = new HashMap<>();

        Pattern p = Pattern.compile("[0-9]");
        Pattern p2 = Pattern.compile("[^0-9]");
        for(int i=0; i<files.length; i++){
            String head = "";
            int number = 0;

            Matcher m = p.matcher(files[i]);
            String value = "";
            if(m.find()){
                head = files[i].substring(0, m.start());
                value = files[i].substring(m.start());
            }

            Matcher m2 = p2.matcher(value);
            if(m2.find()){
                number = Integer.parseInt(value.substring(0, m2.start()>5?5:m2.start()));
            } else{
                number = Integer.parseInt(value.length()>5?value.substring(0, 5):value);
            }

            hm.put(new File(i, head.toLowerCase(), number), i);
        }

        List<File> list = new ArrayList<>(hm.keySet());
        list.sort(Comparator.comparing(File::getHead).thenComparing(File::getNumber).thenComparing(File::getIndex));
        
        String[] answer = new String[files.length];

        for(int i=0; i<files.length; i++){
            answer[i] = files[hm.get(list.get(i))];
        }

        System.out.println(Arrays.asList(answer));
    }
}

class File{
    private int index;
    private String head;
    private int number;

    public File(int index, String head, int number){
        this.index = index;
        this.head = head;
        this.number = number;
    }

    public String getHead(){
        return this.head;
    }

    public int getNumber(){
        return this.number;
    }

    public int getIndex(){
        return this.index;
    }

    @Override
    public String toString() {
        return "File [head=" + head + ", index=" + index + ", number=" + number + "]";
    }

    
}