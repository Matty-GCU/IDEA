package chapter01ioandnio;

import java.io.Serializable;
import java.util.Calendar;

public class Exp1Logistics implements Serializable, Comparable<Exp1Logistics> {
    Calendar calendar;
    String location, preStation, nextStation;
    public Calendar getCalendar() {
        return calendar;
    }
    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getPreStation() {
        return preStation;
    }
    public void setPreStation(String preStation) {
        this.preStation = preStation;
    }
    public String getNextStation() {
        return nextStation;
    }
    public void setNextStation(String nextStation) {
        this.nextStation = nextStation;
    }

    @Override
    public String toString() {
        int y = calendar.get(Calendar.YEAR);
        int m = calendar.get(Calendar.MONTH) + 1;
        int d = calendar.get(Calendar.DAY_OF_MONTH);
        return y + "年" + m + "月"+ d + "日\n当前位于：" + getLocation() + "\n上一站：" + getPreStation() + "\n下一站" + getNextStation() + "\n";
    }

    @Override
    public int compareTo(Exp1Logistics o) {
        Calendar c1 = getCalendar();
        Calendar c2 = o.getCalendar();
        return Integer.compare(0, c1.compareTo(c2));
    }
}
