package com.example.javaprac.algorithm.string;

import java.util.ArrayList;
import java.util.Scanner;

public class Main04 {

  public ArrayList<String> solution(int n, String[] str) {
    ArrayList<String> answer = new ArrayList<>();
//    String은 객체를 한번 만들어 놓으면 그 자체를 변경할수 없다. 새로운 객체를 만들어서 변경된걸 다시 대입해야하니까 객체가 자꾸 만들어진다
//    StringBuilder는 객체를 만들고 놓고 객체 여러개 만들 필요없이 그 객체를 문자를 추가하거나 삭제하거나 replace등을 할 수 있다 따라서 String연산이 많을떄 유리하다
//    for (String x : str) {
//      String tmp = new StringBuilder(x).reverse().toString();
//      answer.add(tmp);
//    }
    for (String x : str) {
      char[] s = x.toCharArray();
      int lt = 0, rt = x.length() - 1;
      while (lt < rt) {
        char tmp = s[lt];
        s[lt] = s[rt];
        s[rt] = tmp;
        lt++;
        rt--;
      }
      String tmp = String.valueOf(s);  //valueOf()는 static으로 선언된 클래스 메소드임 객체. 아니고 클래스. 으로 접근한다
      answer.add(tmp);
    }

    return answer;
  }

  public static void main(String[] args) {
    Main04 T = new Main04();
    Scanner kb = new Scanner(System.in);

    int n = kb.nextInt();
    String[] str = new String[n];
    for (int i = 0; i < n; i++) {
      str[i] = kb.next();
    }
    for (String x : T.solution(n, str)) {
      System.out.println(x);
    }
  }
}
