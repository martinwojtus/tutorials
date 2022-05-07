package com.frontbackend.libraries.mockito;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.frontbackend.libraries.mockito.service.ListProcessor;
import com.frontbackend.libraries.mockito.service.ProcessingService;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoProcessingServiceTest {

    @Mock
    private ListProcessor listProcessor;

    @InjectMocks
    private ProcessingService processingService;

    @Captor
    private ArgumentCaptor<List<String>> captor;

    @Test
    public void shouldProcessListWhenCaptorInAnnotation() {
        when(listProcessor.processList(anyList())).thenCallRealMethod();

        List<String> result = processingService.processList("test");
        verify(listProcessor).processList(captor.capture());

        List<String> captured = captor.getValue();
        Assert.assertEquals(3, captured.size());

        assertThat(captured, is(Arrays.asList("test", "test", "test")));
        assertThat(result, is(Arrays.asList("test:processed", "test:processed", "test:processed")));
    }

    @Test
    public void shouldProcessListWhenCaptorInsideMethod() {
        when(listProcessor.processList(anyList())).thenCallRealMethod();

        @SuppressWarnings("unchecked")
        ArgumentCaptor<List<String>> listCaptor = ArgumentCaptor.forClass(List.class);

        List<String> result = processingService.processList("test");
        verify(listProcessor).processList(listCaptor.capture());

        List<String> captured = listCaptor.getValue();
        Assert.assertEquals(3, captured.size());

        assertThat(captured, is(Arrays.asList("test", "test", "test")));
        assertThat(result, is(Arrays.asList("test:processed", "test:processed", "test:processed")));
    }

}
