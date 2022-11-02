package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Comment;

public interface CommentRepository extends JpaRepository <Comment,Long> {

}
