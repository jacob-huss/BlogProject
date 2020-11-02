package com.tts.techtalentblog.controller;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

// object java file

@Entity
public class BlogPost {

    // fields

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tag;
    private String title;
    private String author;
    private String blogEntry;

    // empty constructor

    public BlogPost() {

    }

    // 3 field constructor

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public BlogPost(String title, String author, String blogEntry, String tag) {
        this.title = title;
        this.author = author;
        this.blogEntry = blogEntry;
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBlogEntry() {
        return blogEntry;
    }

    public void setBlogEntry(String blogEntry) {
        this.blogEntry = blogEntry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BlogPost(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "BlogPost [author=" + author + ", blogEntry=" + blogEntry + ", id=" + id + ", tag=" + tag + ", title="
                + title + "]";
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "tweet_tag", joinColumns = @JoinColumn(name = "blogPost_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

}