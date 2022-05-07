package hash;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// 프로그래머스
// 호텔 방 배정
// https://programmers.co.kr/learn/courses/30/lessons/64063

public class hash11 {
    static Map<Long, Long> hm = new HashMap<>();
    public static void main(String[] args){
        // long k = 10;
        long[] room_number = {1,3,4,1,3,1};

        long[] answer = new long[room_number.length];

        for(int i=0; i<answer.length; i++){
            answer[i] = findEmptyRoom(room_number[i]);
        }

        System.out.println(Arrays.stream(answer).boxed().collect(Collectors.toList()));
    }

    static long findEmptyRoom(long room){
        if(!hm.containsKey(room)){
            hm.put(room, room+1);
            return room;
        }

        long nextRoom = hm.get(room);
        long emptyRoom = findEmptyRoom(nextRoom);
        hm.put(room, emptyRoom);

        return emptyRoom;
    }
}
