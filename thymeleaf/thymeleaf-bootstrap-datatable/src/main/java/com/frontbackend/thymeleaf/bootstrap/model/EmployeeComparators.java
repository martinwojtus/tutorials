package com.frontbackend.thymeleaf.bootstrap.model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import com.frontbackend.thymeleaf.bootstrap.model.paging.Direction;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

public final class EmployeeComparators {

    @EqualsAndHashCode
    @AllArgsConstructor
    @Getter
    static class Key {
        String name;
        Direction dir;
    }

    static Map<Key, Comparator<Employee>> map = new HashMap<>();

    static {
        map.put(new Key("name", Direction.asc), Comparator.comparing(Employee::getName));
        map.put(new Key("name", Direction.desc), Comparator.comparing(Employee::getName)
                                                           .reversed());

        map.put(new Key("start_date", Direction.asc), Comparator.comparing(Employee::getStartDate));
        map.put(new Key("start_date", Direction.desc), Comparator.comparing(Employee::getStartDate)
                                                                 .reversed());

        map.put(new Key("position", Direction.asc), Comparator.comparing(Employee::getPosition));
        map.put(new Key("position", Direction.desc), Comparator.comparing(Employee::getPosition)
                                                               .reversed());

        map.put(new Key("salary", Direction.asc), Comparator.comparing(Employee::getSalary));
        map.put(new Key("salary", Direction.desc), Comparator.comparing(Employee::getSalary)
                                                             .reversed());

        map.put(new Key("office", Direction.asc), Comparator.comparing(Employee::getOffice));
        map.put(new Key("office", Direction.desc), Comparator.comparing(Employee::getOffice)
                                                             .reversed());

        map.put(new Key("extn", Direction.asc), Comparator.comparing(Employee::getExtn));
        map.put(new Key("extn", Direction.desc), Comparator.comparing(Employee::getExtn)
                                                           .reversed());
    }

    public static Comparator<Employee> getComparator(String name, Direction dir) {
        return map.get(new Key(name, dir));
    }

    private EmployeeComparators() {
    }
}
