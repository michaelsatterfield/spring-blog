package com.example.blog.models;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String body;

    @OneToOne
    private User owner;

    public Post() {}

    //constructor
//    create constructor
    public Post(String title, String body,User owner ) {
        this.title = title;
        this.body = body;
        this.owner = owner;
    }
    public Post(Long id,String title, String body, User owner) {
        this.title = title;
        this.body = body;
        this.id = id;
        this.owner = owner;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
