import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class Ticket {
    private String origin;
    private String origin_name;
    private String destination;
    private String destination_name;
    private LocalDate departure_date;
    private LocalTime departure_time;
    private LocalDate arrival_date;
    private LocalTime arrival_time;
    private String carrier;
    private int stops;
    private int price;

    public void setDeparture_date(String departure_date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yy");
        this.departure_date = LocalDate.parse(departure_date,formatter);
    }

    public void setDeparture_time(String departure_time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
        this.departure_time = LocalTime.parse(departure_time,formatter);
    }

    public void setArrival_date(String arrival_date) {
        //this.arrival_date = arrival_date;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yy");
        this.arrival_date = LocalDate.parse(arrival_date,formatter);
    }

    public void setArrival_time(String arrival_time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
        this.arrival_time = LocalTime.parse(arrival_time,formatter);
    }
}
