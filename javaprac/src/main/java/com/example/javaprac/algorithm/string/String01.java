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
    char c = kb.next().charAt(0);  //charAt: 스트링을 인덱스로 접근
    System.out.println(T.solution(str, c));
  }
}