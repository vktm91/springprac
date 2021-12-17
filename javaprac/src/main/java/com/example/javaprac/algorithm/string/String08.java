package com.example.javaprac.algorithm.string;

import java.util.Scanner;

public class String08 {

  public String solution(String s) {
    String answer = "NO";
    s = s.toUpperCase().replaceAll("[^A-Z]", "");  //정규식 써야하니까 replaceAll, replace는 정규식 안됨
    System.out.println(s);
    String tmp = new StringBuilder(s).reverse().toString();
    if (s.equals(tmp)) {
      answer = "YES";
    }

    return answer;
  }

  public static void main(String[] args) {
    String08 T = new String08();
    Scanner kb = new Scanner(System.in);
    String str = kb.nextLine();

  }

}
