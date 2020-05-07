package by.matusevich.multithreading.starter;

import by.matusevich.multithreading.entity.Car;

import java.util.List;

public interface TransportStarter {
    void start(List<Car> cars);
}
