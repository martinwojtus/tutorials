package com.frontbackend.libraries.mockito;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoInOrderTest {

    @Mock
    private Map<String, String> map;

    @Mock
    private List<String> list;

    @InjectMocks
    private SomeClass someClass;

    static class SomeClass {
        private final Map<String, String> map;
        private final List<String> list;

        SomeClass(Map<String, String> map, List<String> list) {
            this.map = map;
            this.list = list;
        }

        public void doSomething() {
            map.put("first", "value1");
            list.add("second");
            map.put("test", list.get(0));
        }
    }

    @Test
    public void testInOrderOnASingleMockedObject() {
        map.put("one", "val1");
        map.put("two", "val2");

        InOrder inOrder = inOrder(map);

        inOrder.verify(map)
               .put("one", "val1");

        inOrder.verify(map)
               .put("two", "val2");
    }

    @Test
    public void testInOrderOnSeveralMockObjects() {
        // Given
        when(list.get(0)).thenReturn("second");

        // When
        someClass.doSomething();

        // Then
        InOrder inOrder = inOrder(map, list);

        inOrder.verify(map)
               .put(anyString(), anyString());
        inOrder.verify(list)
               .add("second");
        inOrder.verify(list)
               .get(0);
        inOrder.verify(map)
               .put("test", "second");
    }
}
