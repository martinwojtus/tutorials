package com.frontbackend.libraries.apachepoi.parser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class XLSXHeader {

    private final String fieldName;
    private final String xlsxColumnName;
    private final int columnIndex;
}
