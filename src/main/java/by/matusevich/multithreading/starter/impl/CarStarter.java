package by.matusevich.multithreading.starter.impl;

import by.matusevich.multithreading.entity.Car;
import by.matusevich.multithreading.starter.TransportStarter;

import java.util.List;

public class CarStarter implements TransportStarter {
    @Override
    public void start(List<Car> cars) {
        for (Car car : cars) {
            Thread thread = new Thread(car);
            thread.start();
        }
    }
}
