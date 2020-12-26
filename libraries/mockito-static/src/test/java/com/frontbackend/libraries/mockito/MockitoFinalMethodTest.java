package com.frontbackend.libraries.mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import org.junit.Test;

public class MockitoFinalMethodTest {

    @Test
    public void testMockingFinalMethod() {
        FinalWelcomeUtil finalClass = new FinalWelcomeUtil();

        FinalWelcomeUtil mock = mock(FinalWelcomeUtil.class);
        given(mock.getWelcomeMessage("John")).willReturn("not anymore");

        assertNotEquals(mock.getWelcomeMessage("John"), finalClass.getWelcomeMessage("John"));
        assertEquals("not anymore", mock.getWelcomeMessage("John"));
        assertEquals("Welcome John", finalClass.getWelcomeMessage("John"));
    }
}
