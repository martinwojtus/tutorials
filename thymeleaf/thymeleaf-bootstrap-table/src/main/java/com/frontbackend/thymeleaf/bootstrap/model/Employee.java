package com.frontbackend.thymeleaf.bootstrap.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @JsonFormat(pattern = "yyyy/MM/dd")
    @JsonProperty("start_date")
    private Date startDate;
    private Integer id;
    private String position;
    private String name;
    private Double salary;
    private String office;
    private Integer extn;

}
