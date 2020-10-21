package com.tts.techtalentblog.BlogPost;

// object java file

public class BlogPost {

    // fields
    private Long id;
    private String title;
    private String author;
    private String blogEntry;
    
    // empty constructor
    
    public BlogPost(){

    }

    // 3 field constructor

    public BlogPost(String title, String author, String blogEntry) {
        this.title = title;
        this.author = author;
        this.blogEntry = blogEntry;
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

    @Override
    public String toString() {
        return "BlogPost [author=" + author + ", blogEntry=" + blogEntry + ", id=" + id + ", title=" + title + "]";
    }
    
    
}
