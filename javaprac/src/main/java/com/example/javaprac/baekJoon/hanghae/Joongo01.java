package com.example.javaprac.baekJoon.hanghae;

import java.util.Scanner;

class Joongo01 {

  public String solution(String vote) {
    String answer = "";
    int cntA = 0;
    int cntB = 0;
    int cntC = 0;
    int majority = vote.length()/2;

    for(int i=0;i<vote.length();i++)
    {
      if(vote.charAt(i) == 'A')
        cntA++;
      else if(vote.charAt(i) == 'B')
        cntB++;
      else if(vote.charAt(i) == 'C')
        cntC++;
    }

    if (cntC >= majority)
      answer = "C";
    else if(cntA > cntB)
      answer = "A";
    else if(cntA < cntB)
      answer = "B";
    else if (cntA == cntB) {
      answer = "AB";
    }

  return answer;
  }

  public static void main(String[] args) {
    Joongo01 solution = new Joongo01();
    Scanner kb = new Scanner(System.in);
    String str = kb.next();
    System.out.println(solution.solution(str));
  }

}
