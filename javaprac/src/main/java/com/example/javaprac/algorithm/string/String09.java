package com.example.javaprac.algorithm.string;

import java.util.Scanner;

// 숫자만 추출하기
public class String09 {
  public int solution(String s) {

    int answer = 0;
//    String answer = "";

    for (char x : s.toCharArray()) {
      System.out.println(x);
        // 아스키 넘버 사용하기 48(0)~57(9)
      if(x>=48 && x<=57) {
        answer=answer*10+(x-48);
      }

//      // Character.isDigit(x) 사용하기
//      if (Character.isDigit(x)) {
//        answer += x;
//      }
    }
    return answer;
//    return Integer.parseInt(answer);
  }

  public static void main(String[] args) {
    String09 T = new String09();
    Scanner kb = new Scanner(System.in);
    String str = kb.next();
    System.out.println(T.solution(str));
  }
}
