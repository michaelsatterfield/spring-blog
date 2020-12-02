package com.example.blog.repos;


import com.example.blog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface PostRepository extends JpaRepository<Post,Long>{

    }
