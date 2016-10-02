package Mesh;

import com.mongodb.BasicDBList;
import com.mongodb.DBObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Mesh {
    private Long squareI;
    private Long squareJ;
    private int timeZone;
    private int weekDay;
    private int devCount;
    private double despersion;
    //private List<DBObject> devices = new ArrayList<DBObject>();
    private BasicDBList devices;

    public Mesh() {
    }

    public Long getSquareI() {
        return squareI;
    }

    public Long getSquareJ() {
        return squareJ;
    }


    public BasicDBList getDevices() {
        return devices;
    }

    public void setDevices(BasicDBList devices) {
        this.devices = devices;
    }

    public void setDespersion(double despersion) {
        this.despersion = despersion;
    }

    public void setDevCount(int devCount) {
        this.devCount = devCount;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }

    public void setTimeZone(int timeZone) {
        this.timeZone = timeZone;
    }

    public void setSquareJ(Long squareJ) {
        this.squareJ = squareJ;
    }

    public void setSquareI(Long squareI) {
        this.squareI = squareI;
    }

    public int getTimeZone() {
        return timeZone;
    }

    public int getDevCount() {
        return devCount;
    }

    public double getDespersion() {
        return despersion;
    }

    public Mesh(Long squareI, Long squareJ, int timeZone, int weekDay, int devCount, double despersion, BasicDBList devices) {
        this.squareI = squareI;
        this.squareJ = squareJ;
        this.timeZone = timeZone;
        this.weekDay = weekDay;
        this.devCount = devCount;
        this.despersion = despersion;
        this.devices = devices;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("squareI", squareI)
                .append("squareJ", squareJ)
                .append("timeZone", timeZone)
                .append("weekDay", weekDay)
                .append("devCount", devCount)
                .append("despersion", despersion)
                .append("devices", devices)
                .toString();
    }

}