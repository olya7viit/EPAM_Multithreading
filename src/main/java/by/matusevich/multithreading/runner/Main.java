package by.matusevich.multithreading.runner;

import by.matusevich.multithreading.entity.Car;
import by.matusevich.multithreading.entity.factory.TransportFactory;
import by.matusevich.multithreading.entity.factory.impl.CarFactory;
import by.matusevich.multithreading.starter.TransportStarter;
import by.matusevich.multithreading.starter.impl.CarStarter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TransportFactory generator = new CarFactory(2);

        List<Car> cars;
        cars = generator.generate();

        TransportStarter starter = new CarStarter();
        starter.start(cars);

    }
}
