package com.alpha.mapstructdemo.dtos;

import lombok.Data;

@Data
public class PostDto {
    private Long postId;
    private String postTitle;
    private String postBody;
    private String postAuthor;
}
