package com.alpha.mapstructdemo.mappers;

import com.alpha.mapstructdemo.dtos.PostDto;
import com.alpha.mapstructdemo.models.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface MyMapper {
    @Mapping(target = "postId", source = "id")
    @Mapping(target = "postTitle", source = "title")
    @Mapping(target = "postBody", source = "content")
    @Mapping(target = "postAuthor", source = "author")
    PostDto postToDto(Post post);
}
