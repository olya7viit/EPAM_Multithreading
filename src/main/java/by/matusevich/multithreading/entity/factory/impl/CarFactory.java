package by.matusevich.multithreading.entity.factory.impl;

import by.matusevich.multithreading.entity.Car;
import by.matusevich.multithreading.entity.TypeCar;
import by.matusevich.multithreading.entity.factory.TransportFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarFactory implements TransportFactory {

    private int carCount;
    private static final int AREA_PASSENGER = 5;
    private static final int AREA_CARGO = 15;
    private static final int WEIGHT_PASSENGER = 3;
    private static final int WEIGHT_CARGO = 6;


    public CarFactory(int carCount) {
        this.carCount = carCount;
    }

    @Override
    public List<Car> generate(){
        List<Car> cars = new ArrayList<Car>();
        TypeCar typeCar = getRandomType();

        for (int i=0;i<carCount;i++) {
            if (typeCar.equals(TypeCar.PASSENGER)) {
                cars.add(new Car(i+1, typeCar, AREA_PASSENGER, WEIGHT_PASSENGER));
            }
            if (typeCar.equals(TypeCar.CARGO)) {
                cars.add(new Car(i+1, typeCar, AREA_CARGO, WEIGHT_CARGO));
            }
        }
        return cars;
    }

    private TypeCar getRandomType() {
        Random random = new Random();
        return TypeCar.values()[random.nextInt(TypeCar.values().length)];
    }
}
