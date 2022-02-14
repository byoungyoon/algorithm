package rescue;

public class Rescue24 {
    public static void main(String[] args) {
        String m = "A";
        String[] musicinfos = { "12:00,12:14,HELLO,CDEFGAB", "13:00,13:14,WORLD,ABCDEF" };

        Rescue24 rescue = new Rescue24();
        System.out.println(rescue.solution(m, musicinfos));
    }

    private String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = 0;

        for (String musicinfo : musicinfos) {
            String[] value = musicinfo.split(",");
            int playTime = time(value[1]) - time(value[0]);

            if (maxPlayTime != 0 && maxPlayTime >= playTime)
                continue;

            value[3] = replaceMusic(value[3]);
            StringBuilder st = new StringBuilder();

            for (int i = 0; i < playTime; i++) {
                st.append(value[3].charAt(i % value[3].length()));
            }

            String replaceM = replaceMusic(m);
            if (st.indexOf(replaceM.toString()) != -1) {
                answer = value[2];
                maxPlayTime = playTime;
            }
        }

        return answer;
    }

    private String replaceMusic(String music) {
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < music.length() - 1; i++) {
            if (music.charAt(i + 1) == '#') {
                st.append((char) (music.charAt(i) + 32));
                i++;
            } else {
                st.append(music.charAt(i));
            }
        }

        if (music.charAt(music.length() - 1) != '#')
            st.append(music.charAt(music.length() - 1));

        return st.toString();
    }

    private int time(String time) {
        String[] value = time.split(":");
        return Integer.parseInt(value[0]) * 60 + Integer.parseInt(value[1]);
    }
}
