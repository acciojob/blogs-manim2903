package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;
    @Autowired
    ImageService imageService1;

    @Autowired
    UserRepository userRepository1;
    @Autowired
    private ImageRepository imageRepository;

    public List<Blog> showBlogs(){
        //find all blogs
        return blogRepository1.findAll();
    }

    public void createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time
        Blog blog=new Blog(); //create the blog object
        User user=userRepository1.findById(userId).get(); // getting the user entity rom user id

        //updating the blog details
        blog.setUser(user); // setting the parent attribute --> set the foreign key
        blog.setTitle(title);
        blog.setContent(content);
        blog.setPubDate(new Date()); //set the current time stamp

        //because of bidirectional mapping
        //Updating the userInformation and changing its blogs
        List<Blog> currentBlogs=user.getBlogList();
        currentBlogs.add(blog);
        user.setBlogList(currentBlogs);

        //only calling the parent userRepository function as the child function will automatically be called by cascading
        userRepository1.save(user);

    }

    public Blog findBlogById(int blogId){
        //find a blog
        return blogRepository1.findById(blogId).get();
    }

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog after creating it
        Image image=imageService1.createAndReturn(blogRepository1.findById(blogId).get(),description,dimensions);
        Blog blog=blogRepository1.findById(blogId).get();
        image.setBlog(blog);
        blog.getImageList().add(image);
        blogRepository1.save(blog);

        return image;
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        Blog blog=blogRepository1.findById(blogId).get();
        if(blog != null){
            blogRepository1.delete(blog);
        }

    }
}
