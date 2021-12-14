package com.example.javaprac.baekJoon.hanghae;

import java.util.Arrays;
import java.util.Scanner;

class Joongo02 {

  public int solution(int[] v) {
    int answer = -1;
    Arrays.sort(v);

    do {
      int tmp = calculate(v);
      answer = Math.max(answer, tmp);

    } while (next_permutation(v));

    return answer;
  }

  private static boolean next_permutation(int[] v) {
    int i = v.length - 1;

    while (i > 0 && v[i] <= v[i - 1]) {
      i -= 1;
    }

    if (i <= 0) {
      return false;
    }

    int j = v.length - 1;

    while (v[j] <= v[i - 1]) {
      j -= 1;
    }

    int temp = v[i - 1];
    v[i - 1] = v[j];
    v[j] = temp;

    j = v.length - 1;

    while (i < j) {
      int temp2 = v[i];
      v[i] = v[j];
      v[j] = temp2;
      i += 1;
      j -= 1;
    }

    return true;
  }

  private static int calculate(int[] a) {
    int sum = 0;
    for (int i = 1; i < a.length; i++) {
      sum += Math.abs(a[i] - a[i - 1]);
    }
    return sum;
  }

  public static void main(String[] args) {
    Joongo02 solution = new Joongo02();
    Scanner kb = new Scanner(System.in);
    int N = kb.nextInt();
    int[] A = new int[N];
    System.out.println(solution.solution(A));
  }

}
