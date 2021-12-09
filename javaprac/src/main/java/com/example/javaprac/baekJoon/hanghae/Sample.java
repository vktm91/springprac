package com.example.javaprac.baekJoon.hanghae;

class Sample {
  public String solution(int num) {
    String answer = "";

    if (num % 2 == 0) {
      answer = "Even";
    } else {
      answer = "Odd";
    }

    return answer;
  }
}