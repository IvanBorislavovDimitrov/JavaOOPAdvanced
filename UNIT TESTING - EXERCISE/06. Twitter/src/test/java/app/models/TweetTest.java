package app.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.List;

public class TweetTest {

    private Client client;
    private Tweet tweet;

    @Before
    public void setUp() {
        this.tweet = new TweetImpl();
        this.client = Mockito.mock(Client.class);
        String mes = this.tweet.sendMessage();
        Mockito.when(this.client.retrieveMessage(mes)).thenReturn(mes);
    }

    @Test
    public void testTweet() throws NoSuchFieldException, IllegalAccessException {
        Assert.assertEquals("I didn't understand the problem", this.client.retrieveMessage(this.tweet.sendMessage()));
    }
}
