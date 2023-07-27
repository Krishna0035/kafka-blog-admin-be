package com.blogadmin.blog.daoservice;


import com.blogadmin.blog.entity.Blog;
import com.blogadmin.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class BlogDaoService {

    @Autowired
    private BlogRepository blogRepository;


    public Blog saveBlog(Blog blog){
        return blogRepository.save(blog);
    }

    public List<Blog> getAllBlogs(PageRequest pageRequest){
        return blogRepository.findAll(pageRequest).getContent();
    }

    public List<Blog> getAllBlogs(){
        return blogRepository.findAll();
    }

    public Blog getABlog(Long id){
        return blogRepository.findById(id).get();
    }

    public List<Blog> getAllBlogsBetweenDates(LocalDateTime startDate,LocalDateTime endDate){
        return blogRepository.findAllByCreatedAtBetweenOrderByCreatedAtDesc(startDate,endDate);
    }

}
