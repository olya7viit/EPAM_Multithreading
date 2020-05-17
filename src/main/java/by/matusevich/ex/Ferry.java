package by.matusevich.ex;

import java.util.ArrayList;
import java.util.List;

public class Ferry implements Runnable {
    private static final int MAX_WEIGHT = 6;

    private final SingleElementBuffer buffer;

    public Ferry(SingleElementBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        List arr = new ArrayList();
        int weight = 0;
        int elem=0;
        while (buffer.getSize() != 0) {
            try {
               /* for (int i=0;i<3;i++){
                    int elem = buffer.get();
                    System.out.println(elem + " перевезли");
                }*/

                /*do {

                    elem = buffer.get();
                    arr.add(elem);
                    weight += elem;
                    /*System.out.println("elem = "+elem);
                    System.out.println(" weight = " + weight);
                } while (weight < MAX_WEIGHT);*/

                while (weight <= MAX_WEIGHT){
                    elem = buffer.get();
                    arr.add(elem);
                    weight += elem;
                }

                Thread.sleep(2000);
                for (Object o : arr) System.out.print(o + " ");

                System.out.println(" перевезли");
                arr.clear();
                weight = 0;


            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
