package com.frontbackend.springboot.person.controller.model.request;

import com.frontbackend.springboot.person.controller.model.paging.PageInfo;
import com.frontbackend.springboot.person.dto.PersonFilter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class PersonFilterRequest {
    private PageInfo pageInfo;
    private PersonFilter filter;
}
