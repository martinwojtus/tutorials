package com.frontbackend.springboot.person.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PageDto<T> {
    private final int totalPages;
    private final long totalElements;
    private final List<T> rows;
}
