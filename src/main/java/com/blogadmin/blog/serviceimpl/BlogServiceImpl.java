package com.blogadmin.blog.serviceimpl;

import com.blogadmin.blog.daoservice.BlogDaoService;
import com.blogadmin.blog.dto.BlogLogDto;
import com.blogadmin.blog.entity.Blog;
import com.blogadmin.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDaoService blogDaoService;


    @Override
    public void createBlogLog(BlogLogDto blogLogDto) {


        Blog blog = new Blog(blogLogDto);

        blogDaoService.saveBlog(blog);


    }
}
