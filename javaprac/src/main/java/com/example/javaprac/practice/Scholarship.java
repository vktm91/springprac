package com.example.javaprac.practice;

public class Scholarship {
  public static void main (String[] args) {
    // 메소드 호출
    printTest("Park", 100, 92); // Park => 전액 장학금!
    printTest("Kim", 82, 96);
    printTest("Choi", 82, 88);
  }
  public static void printTest(String name, int math, int eng) {
    String result = "???";
    // 전액 장학금
    if (math >= 90 && eng >= 90) { // AND: 동시 만족
      result = "전액 장학금!";
    } else if (math >= 90 || eng >= 90) { // OR: 둘중 하나라도 만족?
      result = "반액 장학금!";
    } else {
      result = "다음 기회에~";
    }
    System.out.printf("%s => %s\n", name, result);
  }

  public void calorie() {
    // 삼겹살 3인분
    int n = 3;
    // 칼로리 계산
    double kcal = calculate(n);
    // 결과 출력
    System.out.printf("삼겹살 %d인분: %.2f kcal", n, kcal);
  }
  // 칼로리 계산 메소드
  public static double calculate(int num) {
    double result = 0.0; // 반환 값을 위한 변수
    int gram = num * 180; // 1인분 당, 180g
    result = gram * 5.179; // 1g 당, 5.179 칼로리
    return result;
  }
}