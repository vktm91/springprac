package com.example.javaprac.practice;

public class memo {
    public static void main(String[] args) {
        // 캐스팅 1
        double pi = 3.14;
        System.out.printf("%f\n", pi);
        System.out.printf("%d\n", (int) pi);

        // 캐스팅 2
        double tall = 169.4;
        double weight = 90.77;
        System.out.printf("%d\n", (int) tall);
        System.out.printf("%d\n", (int) weight);

        // 형변환: 문자열 -> 정수
        String seven = "7";
        String pa = "3.14";
        int a = Integer.parseInt(seven);
        double b = Double.parseDouble(pa);
        double c = a + b;
        System.out.printf("%d + %.2f = %.2f", a, b, c);

        // 연습문제
        int r = Integer.parseInt(args[0]);
        double s = Math.PI * r * r;
        System.out.printf("반지름이 %d인 원의 넓이: %.3f", r, s);

    }
}
