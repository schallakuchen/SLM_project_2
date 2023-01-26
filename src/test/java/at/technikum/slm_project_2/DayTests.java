package at.technikum.slm_project_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayTests {
    @Test
    void testDays() {
        Day day1 = new Day(6, 18);
        assertEquals("06:00 - 18:00", day1.toString());

        Day dayClosed = new Day();
        assertEquals("closed", dayClosed.toString());
    }
}
