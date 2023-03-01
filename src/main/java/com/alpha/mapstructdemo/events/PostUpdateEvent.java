package com.alpha.mapstructdemo.events;

import com.alpha.mapstructdemo.dtos.PostDto;
import com.alpha.mapstructdemo.models.Post;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class PostUpdateEvent extends ApplicationEvent {

    private PostDto post;

    public PostUpdateEvent(Object source, PostDto post) {
        super(source);
        this.post = post;
    }
}
