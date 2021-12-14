package Models.timecards;

import java.io.Serializable;

public class Timecard implements Serializable {
    double workedHours;
    Timecard(double _workedHours){
        this.workedHours = _workedHours;
    }
}
