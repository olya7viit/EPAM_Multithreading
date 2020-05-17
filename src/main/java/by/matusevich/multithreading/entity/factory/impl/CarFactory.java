package by.matusevich.multithreading.entity.factory.impl;

import by.matusevich.multithreading.entity.Car;
import by.matusevich.multithreading.entity.TypeCar;
import by.matusevich.multithreading.entity.factory.TransportFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarFactory implements TransportFactory {

    private int carCount;

    public CarFactory(int carCount) {
        this.carCount = carCount;
    }

    @Override
    public List<Car> generate(){
        List<Car> cars = new ArrayList<Car>();

        for (int i=0;i<carCount;i++) {
            TypeCar typeCar = getRandomType();
            if (typeCar.equals(TypeCar.PASSENGER)) {
                cars.add(new Car(i+1, typeCar, TypeCar.PASSENGER.getArea(), TypeCar.PASSENGER.getWeight()));
            }
            if (typeCar.equals(TypeCar.CARGO)) {
                cars.add(new Car(i+1, typeCar, TypeCar.CARGO.getArea(), TypeCar.CARGO.getWeight()));
            }
        }
        return cars;
    }

    private TypeCar getRandomType() {
        Random random = new Random();
        return TypeCar.values()[random.nextInt(TypeCar.values().length)];
    }
}
