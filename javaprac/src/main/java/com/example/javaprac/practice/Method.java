package com.example.javaprac.practice;

public class Method {
    public static void main(String[] args) {
        //주사위 랜덤값
        int x = rollDie();
        System.out.printf("주사위의 눈: %d\n", x);

        //별상자 그리기
        drawRectangle();
    }

    public static int rollDie() {
        double r = 6 * Math.random();
        int temp = (int) r;
        int n = temp + 1;
            return n;
    }

    public static void drawRectangle() {
        String line = drawLine();
        System.out.println(line);
        drawEdge();
        drawLine();
    }

    public static String drawLine() {
        return "******";
    }

    public static void drawEdge() {
        System.out.println("*    *");
    }


}
