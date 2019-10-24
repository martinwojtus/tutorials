package com.frontbackend.thymeleaf.forms.sample.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Setter
@Getter
public class SampleDropdowns {

    private SampleColor color;

    private SampleColor[] colors;
}
