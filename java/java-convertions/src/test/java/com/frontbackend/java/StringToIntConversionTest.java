package com.frontbackend.java;

import static org.assertj.core.api.Java6Assertions.assertThat;

import org.junit.Test;

public class StringToIntConversionTest {

    @Test
    public void whenParseCorrectInt_shouldConvertSuccessfully() {
        String str = "1234";

        int result = Integer.parseInt(str);

        assertThat(result).isEqualTo(1234);
    }

    @Test
    public void whenValueOfCorrectInt_shouldConvertSuccessfully() {
        String str = "-9977";

        int result = Integer.valueOf(str);

        assertThat(result).isEqualTo(-9977);
    }

    @Test(expected = NumberFormatException.class)
    public void whenInvalidInput_parseIntShouldThrowException() {
        String str = "adsf";
        Integer.parseInt(str);
    }
}
