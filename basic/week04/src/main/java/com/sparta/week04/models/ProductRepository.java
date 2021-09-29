package com.sparta.week04.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {   //Long타입 Product에 JpaRepository 사용한다!
}