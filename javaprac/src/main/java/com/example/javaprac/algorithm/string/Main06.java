package com.example.javaprac.algorithm.string;

import java.util.Scanner;

public class Main06 {

  public String solution(String str) {
    String answer = "";
    for (int i = 0; i < str.length(); i++) {
      if (str.indexOf(str.charAt(i)) == i) {
        answer += str.charAt(i);
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Main06 T = new Main06();
    Scanner kb = new Scanner(System.in);
    String str = kb.next();
    System.out.println(T.solution(str));
  }

}
