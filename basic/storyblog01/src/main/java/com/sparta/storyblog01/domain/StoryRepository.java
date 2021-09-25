package com.sparta.storyblog01.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoryRepository extends JpaRepository<Story, Long> {
    List<Story> findAllByOrderByModifiedAtDesc();

}
