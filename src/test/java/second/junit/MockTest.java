package second.junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class MockTest {

    HttpQueryClass httpQueryClass;

    @Before
    public void setUp() {
        System.out.println("Run setUp");
        httpQueryClass = Mockito.mock(HttpQueryClass.class);
    }

    @Test
    public void mockTestExample() {
        Mockito.when(httpQueryClass.query()).thenReturn("test");

        ProcessQuery processQuery = new ProcessQuery(httpQueryClass);

        String result = processQuery.process();
        assertThat(result).isEqualTo("TEST");
    }

}
