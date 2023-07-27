package com.blogadmin.blog.service;

import com.blogadmin.blog.dto.*;

import java.util.List;

public interface BlogService {

    public void createBlogLog(BlogLogDto blogLogDto);

    public void viewBlog(BlogViewLogDto blogViewLogDto);

    public void likeBlog(BlogLikeLogDto blogLikeLogDto);

    public void blogActivity(BlogActivityLogDto blogActivityLogDto);



    // should be ordered by id,cratedAt,lastActivity,like,view
    public List<BlogLogResponseDto> getAllBlogBlogLogs(GetAllBlogRequestDto request);


    public BlogActivityResponseDto getBlogAllActivities(Long id);


    public List<BlogActivityChartData> getBlogActivityChartData();

    public BarChartStatResponseData  getBlogStats();
}
