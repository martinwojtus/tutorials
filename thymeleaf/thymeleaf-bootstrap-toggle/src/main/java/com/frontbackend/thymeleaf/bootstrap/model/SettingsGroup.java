package com.frontbackend.thymeleaf.bootstrap.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SettingsGroup {

    private String group;

    private List<Setting> settingList;
}
