package by.matusevich.ex;

public class Main {
    public static void main(String[] args) {
        SingleElementBuffer buffer = new SingleElementBuffer();
        new Thread(new Car(1,1000,buffer)).start();
        new Thread(new Car(2,2000,buffer)).start();
        new Thread(new Car(3,3000,buffer)).start();
        new Thread(new Car(4,4000,buffer)).start();
        new Thread(new Car(5,4000,buffer)).start();
        new Thread(new Car(6,4000,buffer)).start();
        new Thread(new Ferry(buffer)).start();
    }
}
