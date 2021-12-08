package com.example.javaprac.algorithm.string;

import java.util.Scanner;

class Main01 {

  public int solution(String str, char t) {
    int answer = 0;
    str = str.toUpperCase();
    t = Character.toUpperCase(t);
   for(char x : str.toCharArray()) {  //toCharArray(): 문자열을 한 글자씩 char타입의 배열에 집어넣어준다
     if(x==t) answer++;

    }
    return answer;
  }

  public static void main(String[] args) {
    Main01 T = new Main01();
    Scanner kb = new Scanner(System.in);
    String str = kb.next();
    char c = kb.next().charAt(0);  //charAt(0): 0번째에 있는 문자를 char타입으로 변환
    System.out.println(T.solution(str, c));
  }
}