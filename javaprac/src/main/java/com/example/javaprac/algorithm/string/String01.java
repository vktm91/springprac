package com.example.javaprac.algorithm.string;

import java.util.Scanner;

class String01 {

  public int solution(String str, char t) {
    int answer = 0;
    str = str.toUpperCase();
    t = Character.toUpperCase(t);
   for(char x : str.toCharArray()) {
     if(x==t) answer++;
     
    }
    return answer;
  }

  public static void main(String[] args) {
    String01 T = new String01();
    Scanner kb = new Scanner(System.in);
    String str = kb.next();
    char c = kb.next().charAt(0);  //charAt: 문자열을 한 글자씩 char타입 배열에 집어넣어준다
    System.out.println(T.solution(str, c));
  }
}