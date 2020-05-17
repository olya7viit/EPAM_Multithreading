package by.matusevich.multithreading.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

import java.util.concurrent.locks.ReentrantLock;

public class Query { //TODO singleton
    private static final int TRANSPORTATION_TIME = 3;
    private static final int TIMEOUT = 100;
    private static final int MAX_AREA = 50;
    private static final Logger LOGGER = LogManager.getLogger();
    private static Queue<Car> carsOnTheFerry = new ArrayDeque();
    private static int carrentLoad = 0;
    private static boolean load;
    private ReentrantLock locker;
    private Condition condition;

    Query() {
        locker = new ReentrantLock();
        condition = locker.newCondition();
    }

    public void get() {
        while (true) {
            locker.lock();

            try {


                while (!load) {
                    System.out.println("Паром ожидает.");//TODO убрать
                    //LOGGER.info("Паром ожидает.");
                    condition.signalAll();
                    condition.await();
                }

                TimeUnit.SECONDS.sleep(TRANSPORTATION_TIME);

                int size = carsOnTheFerry.size();
                for (int i = 0; i < size; i++) {
                    System.out.println("Машина " + carsOnTheFerry.poll().getIdCar() + " перевезена.");//TODO убрать
                    //LOGGER.info("Машина " + carsOnTheFerry.poll().getIdCar() + " перевезена.");
                }


            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            } finally {
                locker.unlock();
            }
        }
    }

    public synchronized void addCar(Car car) {
        locker.lock();
        try {
            while (load || (carrentLoad + car.getArea() > MAX_AREA)) {
                System.out.println(load);
                System.out.println(carrentLoad + car.getArea() > MAX_AREA);
                if ((carrentLoad + car.getArea() > MAX_AREA)) {
                    load = true;
                }
                System.out.println("~~Машина " + car.getIdCar() + " ожидает." + car.getArea());//TODO убрать
                // LOGGER.info("Машина " + car.getIdCar() + " ожидает." + car.getArea());
                condition.await();
                System.out.println("111111111111111");
            }

            carsOnTheFerry.add(car);
            carrentLoad += car.getArea();
            System.out.println("Машина " + car.getIdCar() + " в очереди." + car.getArea());//TODO убрать
            //LOGGER.info("Машина " + car.getIdCar() + " в очереди." + car.getArea());
            condition.signalAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }

}
