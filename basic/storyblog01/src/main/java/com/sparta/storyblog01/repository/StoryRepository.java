package com.sparta.storyblog01.repository;

import com.sparta.storyblog01.domain.Story;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoryRepository extends JpaRepository<Story, Long> {
    List<Story> findAllByOrderByModifiedAtDesc();

}
