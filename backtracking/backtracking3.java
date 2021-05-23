package backtracking;
import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스

public class backtracking3 {
  static int answer = 0;
  public static void main(String[] args) {
    String begin = "hit";
    String target = "cog";
    String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
    
    
    Queue<Visited> q = new LinkedList<Visited>();
    boolean[] check = new boolean[words.length];
    Visited visited = new Visited(begin, check, 0);
    q.offer(visited);
    
    bfs(q, words, target);
    
    System.out.println(answer);
  }
  
  static void bfs(Queue<Visited> q, String[] words, String target){
    Visited visited2 = q.poll();
    String value = visited2.getValue();
    boolean[] check = visited2.getCheck();
    int count = visited2.getCount();
    
    for(int i=0; i<words.length; i++){
      if(check[i]) continue;
      int same = 0;
      for(int j=0; j<words[i].length(); j++){
        if(value.charAt(j) == words[i].charAt(j)){
          same = same + 1;
        }
      }
      if(same == 2){
        check[i] = true;{}
        q.offer(new Visited(words[i], check, count+1));
      }
    }
    
    if(value.equals(target)){
      answer = count;
      return;
    }
    
    bfs(q, words, target);
  }
}

class Visited{
  private String value;
  private boolean[] check;
  private int count;
  
  public Visited(String value, boolean[] check, int count){
    this.value = value;
    this.check = check;
    this.count = count;
  }
  
  public String getValue(){
    return this.value;
  }
  
  public boolean[] getCheck(){
    return this.check;
  }
  
  public int getCount(){
    return this.count;
  }
}
