package com.frontbackend.springboot.person.controller.model.paging;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Sorting {

    private String column;
    private SortOrder order;

}
