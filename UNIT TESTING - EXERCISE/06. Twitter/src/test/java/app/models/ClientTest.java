package app.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.List;

public class ClientTest {

    private Client client;
    private Tweet tweet;

    @Before
    public void setUp() {
        this.client = new ClientImpl();
        this.tweet = Mockito.mock(Tweet.class);
        Mockito.when(this.tweet.sendMessage()).thenReturn("Varg Vickernes is a smart man");
    }

    @Test
    public void test_message_receive() throws NoSuchFieldException, IllegalAccessException {
        this.client.retrieveMessage(this.tweet.sendMessage());
        Field field = this.client.getClass().getDeclaredField("receivedMessages");
        field.setAccessible(true);
        List<String> a = (List<String>) field.get(this.client);
        Assert.assertEquals(1, a.size());
    }
}
