package com.blogadmin.blog.serviceimpl;

import com.blogadmin.blog.daoservice.BlogDaoService;
import com.blogadmin.blog.dto.*;
import com.blogadmin.blog.entity.Blog;
import com.blogadmin.blog.entity.BlogActivityLog;
import com.blogadmin.blog.entity.BlogLikeLog;
import com.blogadmin.blog.entity.BlogViewLog;
import com.blogadmin.blog.repository.BlogActivityRepository;
import com.blogadmin.blog.repository.BlogLikeLogRepository;
import com.blogadmin.blog.repository.BlogViewLogRepository;
import com.blogadmin.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDaoService blogDaoService;

    @Autowired
    private BlogViewLogRepository blogViewLogRepository;

    @Autowired
    private BlogLikeLogRepository blogLikeLogRepository;

    @Autowired
    private BlogActivityRepository blogActivityRepository;





    @Override
    public void createBlogLog(BlogLogDto blogLogDto) {


        Blog blog = new Blog(blogLogDto);

        blogDaoService.saveBlog(blog);


    }

    @Override
    public void viewBlog(BlogViewLogDto blogViewLogDto) {
        BlogViewLog blogViewLog = new BlogViewLog(blogViewLogDto);
        blogViewLogRepository.save(blogViewLog);
    }

    @Override
    public void likeBlog(BlogLikeLogDto blogLikeLogDto) {
        BlogLikeLog blogLikeLog = new BlogLikeLog(blogLikeLogDto);
        blogLikeLogRepository.save(blogLikeLog);
    }

    @Override
    public void blogActivity(BlogActivityLogDto blogActivityLogDto) {
        BlogActivityLog blogActivityLog = new BlogActivityLog(blogActivityLogDto);
        blogActivityRepository.save(blogActivityLog);
    }

    @Override
    public List<BlogLogResponseDto> getAllBlogBlogLogs(GetAllBlogRequestDto request) {

        PageRequest pageInformation = getPageInformation(request);

        List<Blog> allBlogs =  !request.getOrderType().equals("totalViews")  && !request.getOrderType().equals("totalLikes") ? blogDaoService.getAllBlogs(pageInformation): blogDaoService.getAllBlogs();





        List<Long> blogIdList = allBlogs.stream().map(blog -> blog.getId()).collect(Collectors.toList());

        List<BlogViewLog> allViewList = blogViewLogRepository.findAllByBlogidIn(blogIdList);

        Map<Long, Long> viewCountMap = allViewList.stream().collect(Collectors.toMap(BlogViewLog::getBlogid, blogViewLog -> allViewList.stream().filter(b -> b.getBlogid().equals(blogViewLog.getBlogid())).count()));

        List<BlogLikeLog> allLikeList = blogLikeLogRepository.findAllByBlogidIn(blogIdList);

        Map<Long, Long> likeCountMap = allLikeList.stream()
                .collect(Collectors.toMap(BlogLikeLog::getBlogid, blogLikeLog -> allLikeList.stream().filter(b->b.getBlogid().equals(blogLikeLog.getBlogid())).count()));



        List<BlogActivityLog> allActivityList = blogActivityRepository.findLastActivityByBlogIds(blogIdList);

        // Convert the List to a Map using blogId as the key and BlogActivityLog object as the value
        Map<Long, BlogActivityLog> blogIdToLastActivityMap = allActivityList.stream()
                .collect(Collectors.toMap(BlogActivityLog::getBlogid, blogActivityLog -> blogActivityLog));






        List<BlogLogResponseDto> blogLogResponseDtos = allBlogs.stream().map(blog -> new BlogLogResponseDto(blog,
                                                                blogIdToLastActivityMap.get(blog.getId()).getActivityAt(),
                                                                blogIdToLastActivityMap.get(blog.getId()).getActivity(),
                                                                viewCountMap.get(blog.getId()),
                                                                likeCountMap.get(blog.getId()))) .collect(Collectors.toList());


        if(request.getOrderType().equals("totalViews") ){
            List<BlogLogResponseDto> collect = blogLogResponseDtos.stream().sorted(Comparator.comparing(BlogLogResponseDto::getTotalViews)).collect(Collectors.toList());
            return collect;
        }
        if(request.getOrderType().equals("totalLikes") ){
            List<BlogLogResponseDto> collect = blogLogResponseDtos.stream().sorted(Comparator.comparing(BlogLogResponseDto::getTotalLikes)).collect(Collectors.toList());
            return collect;
        }

        return blogLogResponseDtos;
    }

    @Override
    public BlogActivityResponseDto getBlogAllActivities(Long id) {

        List<BlogActivityLog> activityLogList = blogActivityRepository.findByBlogidOrderByActivityAtDesc(id);

        List<BlogActivityResponseDto.BlogActivities> activityDtoList = activityLogList.stream().map(activity -> new BlogActivityResponseDto.BlogActivities(activity)).collect(Collectors.toList());


        List<BlogLikeLog> allByBlogLike = blogLikeLogRepository.findAllByBlogid(id);

        List<BlogViewLog> allByBlogview = blogViewLogRepository.findAllByBlogid(id);

        Blog blog = blogDaoService.getABlog(id);

        LocalDateTime lastActivityAt = null;

         String lastActivity = null;

        if(activityLogList.size()>0){
            lastActivityAt=activityLogList.get(0).getActivityAt();
            lastActivity=activityLogList.get(0).getActivity();
        }

        BlogLogResponseDto blogLogResponseDto = new BlogLogResponseDto(blog,lastActivityAt,lastActivity,(long)allByBlogview.size(),(long)allByBlogLike.size());


        BlogActivityResponseDto blogActivityResponseDto = new BlogActivityResponseDto(blogLogResponseDto,activityDtoList);


        return blogActivityResponseDto;
    }


    private PageRequest getPageInformation(GetAllBlogRequestDto request){

        int pageSize = request.getPageSize()==0?10:request.getPageSize();
        int offset = request.getOffset()==0?0:request.getOffset();

        String sortBy =!Objects.isNull(request.getSortBy()) && !request.getSortBy().trim().equalsIgnoreCase("")?request.getSortBy():"id";

        String orderType = !Objects.isNull(request.getOrderType()) && !request.getOrderType().trim().equalsIgnoreCase("")?request.getOrderType().trim():"asc";

        return PageRequest.of(offset,pageSize).withSort(Sort.by(Sort.Direction.fromString(orderType),sortBy));
    }
}
