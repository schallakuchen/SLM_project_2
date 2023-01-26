package at.technikum.slm_project_2;
import java.util.HashMap;
import java.util.Map;

public class OpeningHours {
    private Day monday;
    private Day tuesday;
    private Day wednesday;
    private Day thursday;
    private Day friday;
    private Day saturday;
    private Day sunday;

    public OpeningHours() {
        monday = new Day(9, 17);
        tuesday = new Day();
        wednesday = new Day(9, 17);
        thursday = new Day(9, 17);
        friday = new Day(8, 19);
        saturday = new Day(8, 19);
        sunday = new Day(8, 19);
    }

    public OpeningHours(Day monday, Day tuesday, Day wednesday, Day thursday, Day friday, Day saturday, Day sunday) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }

    public Day getMonday() {
        return monday;
    }

    public void setMonday(Day monday) {
        this.monday = monday;
    }

    public Day getTuesday() {
        return tuesday;
    }

    public void setTuesday(Day tuesday) {
        this.tuesday = tuesday;
    }

    public Day getWednesday() {
        return wednesday;
    }

    public void setWednesday(Day wednesday) {
        this.wednesday = wednesday;
    }

    public Day getThursday() {
        return thursday;
    }

    public void setThursday(Day thursday) {
        this.thursday = thursday;
    }

    public Day getFriday() {
        return friday;
    }

    public void setFriday(Day friday) {
        this.friday = friday;
    }

    public Day getSaturday() {
        return saturday;
    }

    public void setSaturday(Day saturday) {
        this.saturday = saturday;
    }

    public Day getSunday() {
        return sunday;
    }

    public void setSunday(Day sunday) {
        this.sunday = sunday;
    }

    public Map<String, String> getWeekdayMap() {
        Map<String, String> weekdayMap = new HashMap<>(7);
        weekdayMap.put("Mo", monday.toString());
        weekdayMap.put("Tu", tuesday.toString());
        weekdayMap.put("We", wednesday.toString());
        weekdayMap.put("Th", thursday.toString());
        weekdayMap.put("Fr", friday.toString());
        weekdayMap.put("Sa", saturday.toString());
        weekdayMap.put("Su", sunday.toString());
        return weekdayMap;
    }
}
