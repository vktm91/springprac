package com.example.javaprac.practice;

public class Array {
    public static void main(String[] args) {
        int[] runningMinutes = { 42, 66, 57, 54, 88 };
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            sum += runningMinutes[i];
        }

        double average = sum / 5.0;

        System.out.printf("달리기 시간 총합: %d분\n", sum);
        System.out.printf("달리기 시간 평균: %.0f분\n", average);

        // 배열과 파라미터
        int[] evens = { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18 }; // 짝수
        int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19 }; // 소수

        // 계산
        int evenSum = sum(evens);
        int primeSum = sum(primes);

        // 출력
        System.out.println("0 이상 20 미만의 짝수와 소수 중..");
        System.out.printf("짝수의 합: %d\n", evenSum);
        System.out.printf("소수의 합: %d\n", primeSum);

    }

    // 정수형 배열을 입력 받아 총합을 반환
    public static int sum(int[] arr) {
        int sum = 0;

        for (int i=0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum;
    }
}