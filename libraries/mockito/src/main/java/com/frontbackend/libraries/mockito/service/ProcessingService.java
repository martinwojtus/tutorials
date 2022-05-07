package com.frontbackend.libraries.mockito.service;

import java.util.Arrays;
import java.util.List;

public class ProcessingService {

    private final ListProcessor listProcessing;

    public ProcessingService(ListProcessor listProcessing) {
        this.listProcessing = listProcessing;
    }

    public List<String> processList(String str) {
        List<String> list = Arrays.asList(str, str, str);
        return this.listProcessing.processList(list);
    }
}
