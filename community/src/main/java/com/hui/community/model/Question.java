package com.hui.community.model;

import lombok.Data;

@Data
public class Question {

    private Integer id;
    //标题
    private String title;
    //创建时间
    private Long gmtCreate;
    //修改时间
    private Long gmtModified;
    //创建者
    private Integer creator;
    //评论数
    private Integer commentCount;
    //阅读数
    private Integer viewCount;
    //点赞数
    private Integer likeCount;
    //标签
    private String tag;
    //描述
    private String description;


}