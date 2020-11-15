package com.frontbackend.libraries.mockito;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoMockTest {

    interface MyDatabaseConnection {
        boolean openConnection();

        int update(String sql);
    }

    class MyService {
        private final MyDatabaseConnection myDatabaseConnection;

        MyService(MyDatabaseConnection myDatabaseConnection) {
            this.myDatabaseConnection = myDatabaseConnection;
            this.myDatabaseConnection.openConnection();
        }

        public boolean updateRows(String query) {
            int updatedRows = myDatabaseConnection.update(query);
            return updatedRows > 0;
        }
    }

    @Mock
    MyDatabaseConnection myDatabaseConnection;

    @Test
    public void shouldSuccessfullyUpdateRows() {
        // Given
        MyService myService = new MyService(myDatabaseConnection);
        when(myDatabaseConnection.update(anyString())).thenReturn(10);

        // When
        boolean success = myService.updateRows("update table set col = 'val'");

        // Then
        verify(myDatabaseConnection, times(1)).openConnection();
        verify(myDatabaseConnection).update("update table set col = 'val'");
        Assert.assertTrue(success);
    }

    @Test
    public void shouldReturnCorrectUpdatedRowsNumber() {
        // Given
        when(myDatabaseConnection.update(anyString())).thenReturn(10);

        // When
        int rows = myDatabaseConnection.update("update all");

        // Then
        Assert.assertEquals(10, rows);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowAnException() {
        // Given
        when(myDatabaseConnection.openConnection()).thenThrow(new RuntimeException("Connection cannot be opened!"));
        MyService myService = new MyService(myDatabaseConnection);

        // When
        myService.updateRows("update table set col = 'val'");
    }

    @Test
    public void shouldReturnDifferentValueDependentOnMethodParameter() {
        // Given
        when(myDatabaseConnection.update("update table1")).thenReturn(10);
        when(myDatabaseConnection.update("update table2")).thenReturn(20);
        MyService myService = new MyService(myDatabaseConnection);

        // When
        int rows1 = myDatabaseConnection.update("update table1");
        int rows2 = myDatabaseConnection.update("update table2");

        // Then
        Assert.assertEquals(10, rows1);
        Assert.assertEquals(20, rows2);
    }
}
