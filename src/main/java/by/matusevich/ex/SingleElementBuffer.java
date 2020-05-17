package by.matusevich.ex;

import java.util.ArrayList;
import java.util.List;

public class SingleElementBuffer {
    private List<Integer> list = new ArrayList<Integer>();

    public int getSize(){
        return list.size();
    }

    public synchronized void put(Integer newElem) throws InterruptedException {
       /* try {
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
        }*/
    }


    public synchronized Integer get() throws InterruptedException {
        /*while (elem==null){
            this.wait();
        }
        int result = this.elem;
        this.elem = null;
        this.notifyAll();
        return result;*/

        int result = list.get(0);
        list.remove(0);
       // this.notifyAll();
        return result;
    }
}
