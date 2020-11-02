package com.tts.techtalentblog.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BlogPostController {

    @Autowired
    private BlogPostRepository blogPostRepository;

    private List<BlogPost> posts = new ArrayList<>();

    @GetMapping(value = "/")
    public String index(BlogPost blogPost, Model model) {
        posts.removeAll(posts);
        for (BlogPost postFromDB : blogPostRepository.findAll()) {
            posts.add(postFromDB);

        }
        model.addAttribute("posts", posts);
        return "blogpost/index";
    }

    @GetMapping(value = "/blogpost/new")
    public String newBlog(BlogPost blogPost) {
        return "blogpost/new";
    }

    @PostMapping(value = "/blogpost")
    public String addNewBlogPost(BlogPost blogPost, Model model) {
        blogPostRepository.save(new BlogPost(blogPost.getTitle(), blogPost.getAuthor(), blogPost.getBlogEntry(), blogPost.getTag()));
        
        model.addAttribute("title", blogPost.getTitle());
        model.addAttribute("author", blogPost.getAuthor());
        model.addAttribute("blogEntry", blogPost.getBlogEntry());
        model.addAttribute("tag", blogPost.getTag());


        return "blogpost/result";
    }

    

    @RequestMapping(value = "blogposts/delete/{id}")
    public String deletePostById(@PathVariable Long id, BlogPost blogPost) {
        blogPostRepository.deleteById(id);
        return "blogpost/delete";
    }


    @RequestMapping(value = "/blogposts/{id}", method = RequestMethod.GET)

    public String editPostWithId(@PathVariable Long id, BlogPost blogPost, Model model) {

        Optional<BlogPost> post = blogPostRepository.findById(id);
        

        if (post.isPresent()) {

            BlogPost actualPost = post.get();

            model.addAttribute("blogPost", actualPost);

        }

        return "blogpost/edit";

    }

    @RequestMapping(value = "/blogposts/update/{id}")

    public String updateExistingPost(@PathVariable Long id, BlogPost blogPost, Model model) {

        Optional<BlogPost> post = blogPostRepository.findById(id);

        if (post.isPresent()) {

            BlogPost actualPost = post.get();

            actualPost.setTitle(blogPost.getTitle());

            actualPost.setAuthor(blogPost.getAuthor());

            actualPost.setBlogEntry(blogPost.getBlogEntry());

            actualPost.setTag(blogPost.getTag());


            blogPostRepository.save(actualPost);

            model.addAttribute("blogPost", actualPost);

        }

        return "blogpost/result";

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a line of text");
        String tweet = scanner.nextLine();
        Set<String> hashtags = getHashtags(tweet);      
        System.out.println(hashtags.toString());
    }

    public static Set<String> getHashtags(String blogEntry) {
        String[] words = blogEntry.split(" ");
        Set<String> hashtags = new HashSet<String>();
        for (String word : words) {
            if (word.startsWith("#")) {
                hashtags.add(word);
            }
        }
        return hashtags;
    }
}

    

    
