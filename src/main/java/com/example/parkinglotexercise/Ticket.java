package com.example.parkinglotexercise;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Ticket {

    private LocalDateTime entryTime;

    private LocalDateTime exitTime;

    public int[] getDuration() {
        return duration;
    }

    private int[] duration;

    public Ticket(LocalDateTime entryTime, LocalDateTime exitTime){
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.duration=calculateDuration();
    }

    private int[] calculateDuration(){
        int diffDays = (int) ChronoUnit.DAYS.between(entryTime, exitTime);
        int diffHours = (int) ChronoUnit.HOURS.between(entryTime,exitTime);
        int diffMinutes = (int) ChronoUnit.MINUTES.between(entryTime, exitTime);

        int[] result = new int[3];
        result[0] = diffDays;
        result[1] = diffHours;
        result[2] = diffMinutes;

        return result;
    }


}
