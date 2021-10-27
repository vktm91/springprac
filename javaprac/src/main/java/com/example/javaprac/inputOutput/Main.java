package com.example.javaprac.inputOutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        System.out.println("강한친구 대한육군");
        System.out.println("강한친구 대한육군");

        System.out.println("\\    /\\");
        System.out.println(" )  ( ')");
        System.out.println("(  /  )");
        System.out.println(" \\(__)|");

        System.out.println("|\\_/|");
        System.out.println("|q p|   /}");
        System.out.println("( 0 )\"\"\"\\");
        System.out.println("|\"^\"`    |");
        System.out.println("||_/=\\\\__|");

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();
        System.out.println(a + b);

        Scanner scanner1 = new Scanner(System.in);
        int c = scanner1.nextInt();
        int d = scanner1.nextInt();
        scanner1.close();
        if(c > 0 && d < 10) {
        System.out.println(c - d);}

        Scanner scanner2 = new Scanner(System.in);
        int e = scanner2.nextInt();
        int f = scanner2.nextInt();
        scanner2.close();
        System.out.println(e * f);

        Scanner scanner3 = new Scanner(System.in);
        double g = scanner3.nextDouble();
        double h = scanner3.nextDouble();
        scanner3.close();
        System.out.println(g / h);

        Scanner scanner4 = new Scanner(System.in);
        int i = scanner4.nextInt();
        int j = scanner4.nextInt();
        scanner4.close();
        System.out.println(i + j);
        System.out.println(i - j);
        System.out.println(i * j);
        System.out.println(i / j);
        System.out.println(i % j);

    }

}
