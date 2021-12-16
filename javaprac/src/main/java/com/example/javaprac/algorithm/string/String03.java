package com.example.javaprac.algorithm.string;

import java.util.Scanner;

class String03 {

  public String solution(String str) {
    String answer = "";
    int max=Integer.MIN_VALUE; //최대값으로 갱신할거니 일단 최소값으로 초기화
    String[] s=str.split(" ");
    for(String x : s) {
      int len=x.length();
      if (len > max) {
        max=len;
        answer=x;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    String03 T = new String03();
    Scanner kb = new Scanner(System.in);
    String str = kb.nextLine();  //next()는 공백기준 입력, nextLine()은 한 라인기준 입력
    System.out.println(T.solution(str));
  }

}
