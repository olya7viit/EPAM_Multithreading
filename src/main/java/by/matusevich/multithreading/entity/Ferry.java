package by.matusevich.multithreading.entity;

public class Ferry implements Runnable {
    public static final int MAX_AREA = 50;
    public static final int MAX_WEIGHT = 60;

    private static class SingletonHolder {
        public static final Ferry instance = new Ferry();
    }

    private Ferry() { }

    public static Ferry getInstance() {
        return SingletonHolder.instance;
    }

    @Override
    public void run() {
        FerryController controller = new FerryController();
        controller.transport();
    }
}
