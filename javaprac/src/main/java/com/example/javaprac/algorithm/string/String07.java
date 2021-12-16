package com.example.javaprac.algorithm.string;

import java.util.Scanner;

public class String07 {

  public String solution(String str) {
//    방법 1
//    String answer = "Yes";
//    str=str.toUpperCase();
//    int len = str.length();
//    for (int i = 0; i < len / 2; i++) {
//      if (str.charAt(i) != str.charAt(len - i - 1)) {
//        return "NO";
//      }
//    }

//    방법 2 StringBuilder 사용하여 뒤집고 비교하기
    String answer = "NO";
    String tmp = new StringBuilder(str).reverse().toString();
    if (str.equalsIgnoreCase(tmp)) {
      answer = "YES";
    }
    return answer;
  }

  public static void main(String[] args) {
    String07 T = new String07();
    Scanner kb = new Scanner(System.in);
    String str = kb.next();
    System.out.println(T.solution(str));
  }

}
