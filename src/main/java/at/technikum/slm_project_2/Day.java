package at.technikum.slm_project_2;

import java.util.Formatter;

public class Day {
    private int openHour = -1;
    private int closeHour = -1;

    public Day() {
    }

    public Day(int openHour, int closeHour) {
        this.openHour = openHour;
        this.closeHour = closeHour;
    }

    private boolean isClosed() {
        return openHour == -1 && closeHour == -1;
    }

    public int getOpenHour() {
        return openHour;
    }

    public void setOpenHour(int openHour) {
        this.openHour = openHour;
    }

    public int getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(int closeHour) {
        this.closeHour = closeHour;
    }

    @Override
    public String toString() {
        final Formatter formatter = new Formatter();

        return isClosed() ? "closed" : formatter.format("%02d:00 - %02d:00", openHour, closeHour).toString();
    }
}
