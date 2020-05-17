package by.matusevich.ex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Car implements Runnable {
    private int startValue;
    private final int period;
    private final SingleElementBuffer buffer;
    private static final Logger LOGGER = LogManager.getLogger();

    public Car( int startValue, int period, SingleElementBuffer buffer) {
        this.buffer = buffer;
        this.period = period;
        this.startValue = startValue;
    }

    @Override
    public void run() {
        try {
            //LOGGER.info("Машина реди.");
            buffer.put(startValue);
            //Thread.sleep(period);
        } catch (InterruptedException e) {
            return;
        }
    }
}
