package com.example.javaprac.practice;

import java.util.ArrayList;

public class InterfaceType {
    public static void main(String[] args) {
        // 객체 생성
        Orderable g = new Food("감자조림", 9000);
        Orderable b = new Electronics("버즈프로", 200000);
        Orderable a = new Clothing("아디다스자켓", 150000);

        ArrayList<Orderable> list = new ArrayList<Orderable>();
        list.add(g);
        list.add(b);
        list.add(a);

        // 총합 계산
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            Orderable o = list.get(i);
            sum += o.discountedPrice();
        }

        // 결과 출력
        System.out.printf("총합: %d원", sum);
    }
}

interface Orderable {
    public int discountedPrice();
}

class Food implements Orderable {
    private String name;
    private int price;

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }
    /* 1. 오버라이딩을 통해, 음식 할인율을 적용하세요. */
    public int discountedPrice() {
        return (int) (price * 0.9);
    }
}

class Electronics implements Orderable {
    private String name;
    private int price;

    public Electronics(String name, int price) {
        this.name = name;
        this.price = price;
    }
    /* 2. 오버라이딩을 통해, 전자기기 할인율을 적용하세요. */
    public int discountedPrice() {
        return (int) (price * 0.8);
    }
}

class Clothing implements Orderable {
    private String name;
    private int price;

    public Clothing(String name, int price) {
        this.name = name;
        this.price = price;
    }
    /* 3. 오버라이딩을 통해, 의류 할인율을 적용하세요. */
    public int discountedPrice() {
        return (int) (price * 0.7);
    }
}