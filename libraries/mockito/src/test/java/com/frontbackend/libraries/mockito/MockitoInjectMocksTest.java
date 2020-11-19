package com.frontbackend.libraries.mockito;

import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.frontbackend.libraries.mockito.db.DBConnection;
import com.frontbackend.libraries.mockito.model.Post;
import com.frontbackend.libraries.mockito.resources.PostResource;

@RunWith(MockitoJUnitRunner.class)
public class MockitoInjectMocksTest {

    @Mock
    private DBConnection dbConnection;

    @InjectMocks
    private PostResource postResource;

    @Test
    public void shouldOpenConnectionBeforeGettingPosts() {
        List<Post> posts = postResource.getPosts();

        verify(dbConnection).open();
        verify(dbConnection).close();

        Assert.assertEquals(3, posts.size());
    }
}
