package com.blogadmin.blog;


import com.blogadmin.blog.dto.BlogLogResponseDto;
import com.blogadmin.blog.dto.GetAllBlogRequestDto;
import com.blogadmin.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;


    @PostMapping("/get-all-blogs")
    public List<BlogLogResponseDto> getAllBlogs(@RequestBody GetAllBlogRequestDto requestDto){
        return blogService.getAllBlogBlogLogs(requestDto);
    }
}
