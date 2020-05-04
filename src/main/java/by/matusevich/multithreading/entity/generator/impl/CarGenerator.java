package by.matusevich.multithreading.entity.generator.impl;

import by.matusevich.multithreading.entity.Car;
import by.matusevich.multithreading.entity.Ferry;
import by.matusevich.multithreading.entity.TypeCar;
import by.matusevich.multithreading.entity.generator.TransportGenerator;

import java.util.Random;

public class CarGenerator implements TransportGenerator {
    private Ferry ferry;
    private int carCount;
    private static final int AREA_PASSENGER = 5;
    private static final int AREA_CARGO = 15;
    private static final int WEIGHT_PASSENGER = 3;
    private static final int WEIGHT_CARGO = 6;


    public CarGenerator(Ferry ferry, int carCount) {
        this.ferry = ferry;
        this.carCount = carCount;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < carCount) {
            Thread.currentThread().setName(" Generator car");
            count++;

            TypeCar typeCar = getRandomType();

            if (typeCar.equals(TypeCar.PASSENGER)){
                ferry.addCar(new Car(typeCar,AREA_PASSENGER,WEIGHT_PASSENGER));
            }
            if (typeCar.equals(TypeCar.CARGO)){
                ferry.addCar(new Car(typeCar,AREA_CARGO,WEIGHT_CARGO));
            }

            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }

    private TypeCar getRandomType() {
        Random random = new Random();
        return TypeCar.values()[random.nextInt(TypeCar.values().length)];
    }
}
