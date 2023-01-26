package at.technikum.slm_project_2;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class OpeningHoursController {

    private OpeningHours openingHours = new OpeningHours();

    @PutMapping("api/hours/set")
    ResponseEntity setOpeningHours(@RequestParam("day") String dayString, @RequestParam int open, @RequestParam int close) {
        if (open < 0 || open > 23) {
            return ResponseEntity.internalServerError().body("invalid open time: " + open);
        }

        if (close < 0 || close > 23) {
            return ResponseEntity.internalServerError().body("invalid close time: " + close);
        }

        final Day day = getDayForString(dayString);

        if (day != null) {
            day.setOpenHour(open);
            day.setCloseHour(close);
            return ResponseEntity.ok("updated opening hours for " + dayString + " (open: " + open + ", close: " + close + ")");
        } else {
            return ResponseEntity.internalServerError().body("Could not set weekday");
        }
    }

    @GetMapping("api/hours")
    @CrossOrigin(origins = "http://localhost:4200")
    Map<String, String> getOpeningHours() {
        return this.openingHours.getWeekdayMap();
    }

    @PutMapping("api/hours/reset")
    ResponseEntity resetWorkingHours() {
        this.openingHours = new OpeningHours();
        return ResponseEntity.ok("working hours were reset");
    }

    @PutMapping("api/hours/close")
    ResponseEntity closeDay(@RequestParam("day") String dayString) {
        final Day day = getDayForString(dayString);
        if (day == null) {
            return ResponseEntity.internalServerError().body("invalid weekday " + dayString);
        }
        day.setOpenHour(-1);
        day.setCloseHour(-1);
        return ResponseEntity.ok("closed day: " + dayString);
    }

    private Day getDayForString(final String dayString) {
        switch (dayString.toLowerCase()) {
            case "mo":
                return openingHours.getMonday();
            case "tu":
                return openingHours.getTuesday();
            case "we":
                return openingHours.getWednesday();
            case "th":
                return openingHours.getThursday();
            case "fr":
                return openingHours.getFriday();
            case "sa":
                return openingHours.getSaturday();
            case "su":
                return openingHours.getSunday();
            default:
                return null;
        }
    }
}
