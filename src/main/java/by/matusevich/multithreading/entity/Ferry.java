package by.matusevich.multithreading.entity;

import java.util.ArrayDeque;
import java.util.Queue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ferry  {

    private Queue<Car> carsOnTheFerry = new ArrayDeque();
    private Queue<Car> queueOfCars = new ArrayDeque();
    private static final int MAX_AREA = 50;
    private static final int MAX_WEIGHT = 60;
    private static final Logger LOGGER = LogManager.getLogger();

    private static class SingletonHolder {
        public static final Ferry instance = new Ferry();
    }

    private Ferry() {}

    public static Ferry getInstance()  {
        return SingletonHolder.instance;
    }

    public void addCar(Car car){
        queueOfCars.add(car);
        LOGGER.info("Машина " + car.getIdCar() + " в очереди.");
    }

    public void removeCar(Car car){

    }

    private void move(){

    }

    private void load(Car car){

    }
}
