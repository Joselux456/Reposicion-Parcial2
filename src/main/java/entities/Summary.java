package entities;

import java.time.LocalDate;

public class Summary {

    private int activeProjects;
    private LocalDate date;

    public Summary( LocalDate date,int activeProjects) {
        this.activeProjects = activeProjects;
        this.date = date;
    }

    public int getActiveProjects() {
        return activeProjects;
    }

    public LocalDate getDate() {
        return date;
    }
}
