package com.frontbackend.thymeleaf.posts.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.frontbackend.thymeleaf.posts.model.Post;

@Service
public class PostService {

    public List<Post> preparePosts() {
        return IntStream.rangeClosed(1, 10)
                        .mapToObj(operand -> Post.builder()
                                                 .id(operand)
                                                 .title(UUID.randomUUID()
                                                            .toString())
                                                 .date(createRandomDate())
                                                 .build())
                        .collect(Collectors.toList());
    }

    private int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    private Date createRandomDate() {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(2018, 2019);
        return Date.from(LocalDate.of(year, month, day)
                                  .atStartOfDay(ZoneId.systemDefault())
                                  .toInstant());
    }
}
