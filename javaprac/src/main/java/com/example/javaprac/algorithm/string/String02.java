package com.example.javaprac.algorithm.string;

import java.util.Scanner;

class String02 {

  public String solution(String str) {
    String answer = "";
    for (char x : str.toCharArray()) {
      if (Character.isLowerCase(x)) {
        answer += Character.toUpperCase(x);
      } else {
        answer += Character.toLowerCase(x);
      }
//      //아스키 넘버 이용하는 방식
//      //대문자A는 65~90 소문자a는 97~122, 즉 소문자에서 32씩 빼면 대문자가 된다
//      //사실 char는 정수형이다
//      if (x >= 97 && x <= 122) {
//        answer += (char) (x - 32) //소문자를 대문자로 변환, char로 캐스팅
//      } else {
//        answer += (char) (x + 32); //대문자를 소문자로 변환
//      }
    }
    return answer;
  }

  public static void main(String[] args) {
    String02 T = new String02();
    Scanner kb = new Scanner(System.in);
    String str = kb.next();
    System.out.println(T.solution(str));
  }
}
