package pl.edu.amu.pracprog;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class JsonSerializationTest {

    Gson gson = new Gson();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void localTimeTest() throws Exception {
        LocalDateTime now = LocalDateTime.now();
        String serializedNow = gson.toJson(now);
        LocalDateTime deserializedNow = gson.fromJson(serializedNow, LocalDateTime.class);
        assertEquals(now,deserializedNow);
    }

}