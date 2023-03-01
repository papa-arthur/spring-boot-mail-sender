package com.alpha.mapstructdemo.controllers;

import com.alpha.mapstructdemo.dtos.PostDto;
import com.alpha.mapstructdemo.events.PostCreatedEvent;
import com.alpha.mapstructdemo.events.PostUpdateEvent;
import com.alpha.mapstructdemo.events.SendMailEvent;
import com.alpha.mapstructdemo.mappers.MyMapper;
import com.alpha.mapstructdemo.models.Post;
import com.alpha.mapstructdemo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
public class PostController {
    private final PostRepository repository;
    private final MyMapper mapper;

    private final ApplicationEventPublisher eventPublisher;

    @PostMapping("/post")
    public ResponseEntity<PostDto> createPost(@RequestBody Post post) {
        var res = mapper.postToDto(repository.save(post));
        eventPublisher.publishEvent(new PostCreatedEvent(this, res));
        eventPublisher.publishEvent(new SendMailEvent(this, res));
        eventPublisher.publishEvent(new PostUpdateEvent(this, res));


        return ResponseEntity.ok().body(res);

    }


}
