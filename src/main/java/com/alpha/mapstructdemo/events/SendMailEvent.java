package com.alpha.mapstructdemo.events;

import com.alpha.mapstructdemo.dtos.PostDto;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class SendMailEvent extends ApplicationEvent {
    private PostDto post;

    public SendMailEvent(Object source, PostDto post) {
        super(source);
        this.post = post;
    }
}
