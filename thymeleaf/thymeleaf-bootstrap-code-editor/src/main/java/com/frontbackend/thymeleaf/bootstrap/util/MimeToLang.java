package com.frontbackend.thymeleaf.bootstrap.util;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.frontbackend.thymeleaf.bootstrap.model.ModeInfo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MimeToLang {

    public String getLangByMime(String mime) {
        return loadModeInfo().stream()
                             .filter(modeInfo -> {
                                 if (modeInfo.getMimes() != null && !modeInfo.getMimes()
                                                                             .isEmpty()) {
                                     return modeInfo.getMimes()
                                                    .contains(mime);
                                 } else {
                                     return modeInfo.getMime()
                                                    .equals(mime);
                                 }
                             })
                             .map(modeInfo -> modeInfo.getName()
                                                      .toLowerCase())
                             .findFirst()
                             .orElse("Plain Text")
                             .toLowerCase();
    }

    private List<ModeInfo> loadModeInfo() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(getClass().getClassLoader()
                                                    .getResourceAsStream("mime.json"),
                    new TypeReference<List<ModeInfo>>() {
                    });
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return Collections.emptyList();
    }
}
