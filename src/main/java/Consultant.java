import java.time.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Consultant {
    private DataBase database;

    public Consultant(DataBase database) {
        this.database = database;
    }

    /***
     * узнать среднее время перелета
     * @param originName - название города отправления
     * @param destinationName - название города прибытия
     * @return
     */
    public Duration averageFlightTime(String originName, String destinationName){
        long sum=0;
        int count=0;
        LocalDateTime departureDate, arrivalDate;
        for(Ticket ticket: database.getTickets()){
            if(ticket.getOrigin_name().equals(originName)&&ticket.getDestination_name().equals(destinationName)) {
                departureDate = LocalDateTime.of(ticket.getDeparture_date(), ticket.getDeparture_time());
                arrivalDate = LocalDateTime.of(ticket.getArrival_date(), ticket.getArrival_time());
                sum += Duration.between(departureDate,arrivalDate).getSeconds();
                count++;
            }
        }
        if(count==0){return null;}
        return Duration.ofSeconds(sum/count);
    }

    /***
     * узнать процентиль времени перелета
     * @param originName - название города отправления
     * @param destinationName - название города прибытия
     * @param percentile - процентиль
     * @return
     */
    public Duration flightTimePercentile(String originName, String destinationName, double percentile){
        List<Long> durationFlightTime = new ArrayList<>();
        LocalDateTime departureDate, arrivalDate;
        for(Ticket ticket: database.getTickets()){
            if(ticket.getOrigin_name().equals(originName)&&ticket.getDestination_name().equals(destinationName)) {
                departureDate = LocalDateTime.of(ticket.getDeparture_date(), ticket.getDeparture_time());
                arrivalDate = LocalDateTime.of(ticket.getArrival_date(), ticket.getArrival_time());
                durationFlightTime.add(Duration.between(departureDate,arrivalDate).getSeconds());
            }
        }
        Collections.sort(durationFlightTime);
        int index = (int)Math.ceil(percentile/100*durationFlightTime.size());
        return Duration.ofSeconds(durationFlightTime.get(index));
    }
}