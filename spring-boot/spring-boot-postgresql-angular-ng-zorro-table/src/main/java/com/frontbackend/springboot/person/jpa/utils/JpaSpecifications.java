package com.frontbackend.springboot.person.jpa.utils;

import java.util.List;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

@UtilityClass
public class JpaSpecifications {

    public <T> Specification<T> upperLike(String value, String columnName) {
        return !StringUtils.hasText(value) ?
                null :
                ((root, query, cb) -> cb.like(cb.upper(root.get(columnName)), "%" + value.toUpperCase() + "%"));
    }

    public <T> Specification<T> checkList(List<?> values, String columnName) {
        return (values == null || values.isEmpty()) ?
                null :
                ((root, query, cb) -> root.get(columnName)
                        .in(values));
    }
}
