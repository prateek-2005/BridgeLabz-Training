package stream_api;
import java.util.*;
import java.util.stream.*;

public class IoTSensorReadings {

    public static void main(String[] args) {

        List<Double> sensorReadings = Arrays.asList(
            22.5, 35.2, 18.9, 40.6, 27.3, 45.1
        );

        double threshold = 30.0;

        sensorReadings.stream()
                      .filter(reading -> reading > threshold)
                      .forEach(reading ->
                          System.out.println("Alert! High Sensor Reading: " + reading)
                      );
    }
}
