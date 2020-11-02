package com.tts.techtalentblog.controller;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tag_id")
    private Long id;

    private String phrase;

    @ManyToMany(mappedBy = "tags")
    private List<BlogPost> blogPosts;

    
    public Long getId() {
    return id;
    }

    public String getPhrase() {
    return phrase;
    }

    public void setPhrase(String phrase) {
    this.phrase = phrase;
    }

    public List<BlogPost> getBlogPosts() {
    return blogPosts;
    }

    public void setBlogPosts(List<BlogPost> blogPosts) {
    this.blogPosts = blogPosts;
    }

    @Override
    public String toString() {
    return "Tag [id=" + id + ", phrase=" + phrase + ", blogPosts=" + blogPosts + "]";
    }

}
