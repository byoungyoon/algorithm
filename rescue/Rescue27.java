package rescue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Rescue27 {
    public static void main(String[] args) {
        String word = "blind";
        String[] pages = {
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>",
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>",
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>" };

        Rescue27 test = new Rescue27();
        System.out.println(test.solution(word, pages));
    }

    private int solution(String word, String[] pages) {
        Map<String, List<Integer>> link = new HashMap<>();

        word = word.toLowerCase();
        Score[] score = new Score[pages.length];
        for (int i = 0; i < score.length; i++) {
            score[i] = new Score();
        }

        for (int i = 0; i < pages.length; i++) {
            String body = pages[i].substring(pages[i].indexOf("<body>") + 6, pages[i].indexOf("</body>"));

            String content = body;
            int tagOpen = 0;
            int tagClose = 0;

            while (content.indexOf("<") != -1) {
                tagOpen = content.indexOf("<");
                tagClose = content.indexOf(">");

                StringTokenizer st = new StringTokenizer(content.substring(0, tagOpen));
                score[i].setDef(score[i].getDef() + onDef(st, word));

                String tag = content.substring(tagOpen + 1, tagClose);
                if (tag.startsWith("a")) {
                    tag = tag.substring(tag.indexOf("https://"), tag.lastIndexOf("\""));

                    link.computeIfAbsent(tag, data -> new ArrayList<>()).add(i);
                    score[i].setOut(score[i].getOut() + 1);

                }
                content = content.substring(tagClose + 1);
            }

            StringTokenizer st = new StringTokenizer(content);
            score[i].setDef(score[i].getDef() + onDef(st, word));
        }

        int answer = 0;
        double max = 0;
        for (int i = 0; i < pages.length; i++) {
            String url = getUrl(pages[i]);
            double num = score[i].getDef();
            if (link.containsKey(url)) {
                List<Integer> list = link.get(url);
                for (int j = 0; j < list.size(); j++) {
                    Score sc = score[list.get(j)];
                    num += (double) sc.getDef() / sc.getOut();
                }
            }
            if (num > max) {
                max = num;
                answer = i;
            }
        }
        return answer;
    }

    private String getUrl(String page) {
        String head = page.substring(page.indexOf("<head>") + 6, page.indexOf("</head>"));
        String pattern = "<meta property=\"og:url\" content=\"";
        String url = head.substring(head.indexOf(pattern) + pattern.length());
        url = url.substring(0, url.indexOf("\""));

        return url;
    }

    private int onDef(StringTokenizer st, String word) {
        int result = 0;
        while (st.hasMoreTokens()) {
            String token = st.nextToken().toLowerCase();

            StringTokenizer tokenSt = new StringTokenizer(token.replaceAll("[^a-z]", " "));
            while (tokenSt.hasMoreTokens()) {
                if (tokenSt.nextToken().equals(word)) {
                    result++;
                }
            }
        }
        return result;
    }
}

class Score {
    private int def; // 기본점수 : 검색어 등장 횟수
    private int out; // 외부 링크 점수 : 다른 페이지로 연결된 링크 수

    public Score() {
        this.def = 0;
        this.out = 0;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setOut(int out) {
        this.out = out;
    }

    public int getDef() {
        return this.def;
    }

    public int getOut() {
        return this.out;
    }

    @Override
    public String toString() {
        return "def : " + this.def + ", out : " + this.out;
    }
}
