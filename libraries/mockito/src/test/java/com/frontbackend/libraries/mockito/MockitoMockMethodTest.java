package com.frontbackend.libraries.mockito;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;

import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mockito;

public class MockitoMockMethodTest {

    @Test
    public void shouldAddItemsToList() {
        @SuppressWarnings("unchecked")
        ArrayList<String> mocked = Mockito.mock(ArrayList.class);

        mocked.add("one");
        mocked.add("two");

        Mockito.verify(mocked, times(2))
               .add(anyString());
        Mockito.verify(mocked)
               .add("one");
        Mockito.verify(mocked)
               .add("two");
    }
}
