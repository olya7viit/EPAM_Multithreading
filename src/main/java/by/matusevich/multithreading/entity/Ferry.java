package by.matusevich.multithreading.entity;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Ferry implements Runnable {

    private Queue<Car> carsOnTheFerry = new ArrayDeque();
    private Queue<Car> queueOfCars = new ArrayDeque();

    private static final int MAX_AREA = 50;
    private static final int MAX_WEIGHT = 60;
    private static final Logger LOGGER = LogManager.getLogger();
    private static ReentrantLock locker = new ReentrantLock();
    private static Condition condition = locker.newCondition();

    private static class SingletonHolder {
        public static final Ferry instance = new Ferry();
    }

    private Ferry() {
    }

    public static Ferry getInstance() {
        return SingletonHolder.instance;
    }

    @Override
    public void run() {
        Query query = new Query();
        query.get();
    }

   /* public void addCar(Car car){
        queueOfCars.add(car);
        LOGGER.info("Машина " + car.getIdCar() + " в очереди.");
        locker.lock();
        try{
            // пока нет доступных товаров на складе, ожидаем



            // сигнализируем
            condition.signalAll();
        }
        finally{
            locker.unlock();
        }
    }*/


}
