package at.technikum.slm_project_2;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpeningHoursTest {
    @Test
    void validateDefaultWeekdayMap() {
        Map<String, String> weekdayMap = new OpeningHours().getWeekdayMap();
        assertEquals("09:00 - 17:00", weekdayMap.get("Mo"));
        assertEquals("closed", weekdayMap.get("Tu"));
        assertEquals("09:00 - 17:00", weekdayMap.get("We"));
        assertEquals("09:00 - 17:00", weekdayMap.get("Th"));
        assertEquals("08:00 - 19:00", weekdayMap.get("Fr"));
        assertEquals("08:00 - 19:00", weekdayMap.get("Sa"));
        assertEquals("08:00 - 19:00", weekdayMap.get("Su"));
    }
}
