package by.matusevich.multithreading.entity;

import java.util.ArrayDeque;
import java.util.Queue;

public class Ferry  {

    private Queue<Car> cars = new ArrayDeque();
    private static final int maxArea = 50;
    private static final int maxWeight = 60;
    private int carsCounter = 0;

    private Ferry() {}

    private static class SingletonHolder {
        public static final Ferry instance = new Ferry();
    }

    public static Ferry getInstance()  {
        return SingletonHolder.instance;
    }

    public void addCar(Car car){

    }

    public void removeCar(Car car){

    }
}
