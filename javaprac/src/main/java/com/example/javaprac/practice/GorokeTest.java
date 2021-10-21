package com.example.javaprac.practice;

public class GorokeTest {
    public static void main(String[] args) {
        /* 1. TOP 3 고로케를 객체로 만드세요. */
        Goroke pizza = new Goroke("피자", 1000);
        Goroke vegi = new Goroke("야채", 800);
        Goroke redBean = new Goroke("팥", 500);
        /* 2. 고로케 정보를 출력하세요. */
        System.out.println(pizza.str());
        System.out.println(vegi.str());
        System.out.println(redBean.str());
    }
}

class Goroke {
    // 필드
    String name;
    int price;

    // 생성자
    Goroke(String n, int p) {
        name = n;
        price = p;
    }

    // 메소드
    String str() {
        return String.format("Goroke { name: %s, price: %d원 }", name, price);
//        public String str() {
//        return "Goroke { name: " + name + ", price: " + price + "원 }";
    }
}