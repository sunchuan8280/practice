package datetest;

import java.time.ZonedDateTime;

import org.junit.Test;

public class DateTest {
    @Test
    public void testDate() {
        String s = "2017-05-19T00:09:38.153";
        ZonedDateTime zdt = ZonedDateTime.parse(s);
        System.out.println(zdt.toOffsetDateTime());
    }

}
