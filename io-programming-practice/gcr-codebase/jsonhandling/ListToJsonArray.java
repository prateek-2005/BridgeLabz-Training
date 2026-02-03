package jsonhandling;
import java.util.*;
import com.google.gson.Gson;

class Car1 {
    String brand;
    int year;

    Car1(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }
}

public class ListToJsonArray {
    public static void main(String[] args) {

        List<Car1> cars = new ArrayList<>();
        cars.add(new Car1("Toyota", 2022));
        cars.add(new Car1("Honda", 2021));

        Gson gson = new Gson();
        String jsonArray = gson.toJson(cars);

        System.out.println(jsonArray);
    }
}
