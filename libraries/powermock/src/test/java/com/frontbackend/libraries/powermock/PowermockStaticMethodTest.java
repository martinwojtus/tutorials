package com.frontbackend.libraries.powermock;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.frontbackend.libraries.powermock.utils.WelcomeUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest(WelcomeUtil.class)
public class PowermockStaticMethodTest {

    @Test
    public void shouldMockStaticMethodTest() {
        final String value = "Guten Tag John";

        mockStatic(WelcomeUtil.class);

        when(WelcomeUtil.generateWelcome("John")).thenReturn(value);

        assertEquals("Guten Tag John", WelcomeUtil.generateWelcome("John"));
    }
}
