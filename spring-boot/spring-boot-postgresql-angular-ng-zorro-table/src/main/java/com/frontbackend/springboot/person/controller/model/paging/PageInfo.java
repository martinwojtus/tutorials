package com.frontbackend.springboot.person.controller.model.paging;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PageInfo {

    private int pageNumber;
    private int pageSize;
    private List<Sorting> sort;

}
