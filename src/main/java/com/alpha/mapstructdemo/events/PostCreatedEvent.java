package com.alpha.mapstructdemo.events;

import com.alpha.mapstructdemo.dtos.PostDto;
import com.alpha.mapstructdemo.models.Post;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class PostCreatedEvent extends ApplicationEvent {

    private PostDto post;

    public PostCreatedEvent(Object source, PostDto post) {
        super(source);
        this.post = post;

    }
}
