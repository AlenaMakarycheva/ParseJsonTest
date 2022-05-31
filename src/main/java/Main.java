import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        DataBaseLoader loader = new JsonDataBaseLoader();
        DataBase dataBase = loader.load("tickets.json");
        Consultant consultant = new Consultant(dataBase);
        printFlightTime(consultant,  "Владивосток","Тель-Авив");
        printPercentile(consultant,  "Владивосток", "Тель-Авив", 90);
    }

    private static void printPercentile(Consultant consultant, String from, String to, double percentile) {
        Duration result = consultant.flightTimePercentile(from, to,percentile);
        System.out.println("90-й процентиль времени полета между городами " + from + " и " + to + " равен " + result.toDays() + " д. " + result.toHours() % 24 + " ч. " + result.toMinutes() % 60 + " мин." );
    }

    private static void printFlightTime(Consultant consultant, String from, String to) {
        Duration averageFlightTime = consultant.averageFlightTime(from, to);
        if (averageFlightTime == null) {
            System.out.println("Во входном файле нет данных о полётах");
        }
        else {
            System.out.println("Cреднее время полета между городами " + from + " и " + to + " составляет " + averageFlightTime.toDays() + " д. " + averageFlightTime.toHours() % 24 + " ч. " + averageFlightTime.toMinutes() % 60 + " мин." );
        }
    }
}