package by.matusevich.multithreading.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

import java.util.concurrent.locks.ReentrantLock;

public class FerryController {

    private static Queue<Car> carsOnTheFerry = new ArrayDeque();
    private static int currentLoadArea;
    private static int currentLoadWEIGHT;
    private static boolean load;
    private Ferry ferry;
    private static int countCar;
    private static final int TRANSPORTATION_TIME = 3;
    private static final int TIMEOUT = 100;
    private static final Logger LOGGER = LogManager.getLogger();
    private ReentrantLock locker;
    private Condition condition;

    FerryController() {
        locker = new ReentrantLock();
        condition = locker.newCondition();
        ferry = Ferry.getInstance();
    }

    public void transport() {
        while (countCar!=0) {
            locker.lock();
            try {
                TimeUnit.MILLISECONDS.sleep(TIMEOUT);

                while (!load) {
                    LOGGER.info("Паром ожидает.");
                    condition.await();
                }

                TimeUnit.SECONDS.sleep(TRANSPORTATION_TIME);

                int size = carsOnTheFerry.size();
                for (int i = 0; i < size; i++) {
                    LOGGER.info("Машина " + carsOnTheFerry.poll().getIdCar() + " перевезена.");
                    countCar--;
                }

                load = false;
                currentLoadArea = 0;
                currentLoadWEIGHT = 0;
                condition.signalAll();
                TimeUnit.MILLISECONDS.sleep(TIMEOUT);
            } catch (InterruptedException e) {
            } finally {
                locker.unlock();
            }
        }
    }

    public void addCar(Car car) {
        locker.lock();
        countCar++;
        try {
            while (load ||
                    (currentLoadArea + car.getArea() > ferry.MAX_AREA) ||
                     currentLoadWEIGHT + car.getWeight() > ferry.MAX_WEIGHT) {
                load = true;
                LOGGER.info("Машина " + car.getIdCar() + " ожидает." + car.getArea());
                condition.await();
            }

            carsOnTheFerry.add(car);
            currentLoadArea += car.getArea();
            currentLoadWEIGHT += car.getWeight();

            LOGGER.info("Машина " + car.getIdCar() + " на пароме." + car.getArea());
            condition.signalAll();
        } catch (InterruptedException e) {
        } finally {
            locker.unlock();
        }
    }

}
