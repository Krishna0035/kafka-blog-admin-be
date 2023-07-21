package com.blogadmin.blog.daoservice;


import com.blogadmin.blog.entity.Blog;
import com.blogadmin.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BlogDaoService {

    @Autowired
    private BlogRepository blogRepository;


    public Blog saveBlog(Blog blog){
        return blogRepository.save(blog);
    }

}
