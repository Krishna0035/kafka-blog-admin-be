package com.blogadmin.blog;


import com.blogadmin.blog.dto.*;
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

    @GetMapping("/get-blog-activity/{id}")
    public BlogActivityResponseDto getAllBlogs(@PathVariable("id") Long id){
        return blogService.getBlogAllActivities(id);
    }

    @GetMapping("/get-blog-activity-chart-data")
    public List<BlogActivityChartData> getAllBlogsChartData(){
        return blogService.getBlogActivityChartData();
    }

    @GetMapping("/get-blog-stat")
    public BarChartStatResponseData getAllBlogsStats(){
        return blogService.getBlogStats();
    }
}
