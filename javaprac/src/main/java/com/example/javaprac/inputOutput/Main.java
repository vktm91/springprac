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
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        scanner.close();
        System.out.println(c - d);

        Scanner scanner2 = new Scanner(System.in);
        int e = scanner.nextInt();
        int f = scanner.nextInt();
        scanner.close();
        System.out.println(e * f);

        Scanner scanner3 = new Scanner(System.in);
        int g = scanner.nextInt();
        int h = scanner.nextInt();
        scanner.close();
        System.out.println(g / h);

    }

}
