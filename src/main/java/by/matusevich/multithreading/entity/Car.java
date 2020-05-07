package by.matusevich.multithreading.entity;

public class Car implements Runnable{
    private long idCar;
    private TypeCar typeCar;
    private double area;
    private double weight;

    public Car(){}

    public Car(long idCar, TypeCar typeCar, double area, double weight) {
        this.idCar = idCar;
        this.typeCar = typeCar;
        this.area = area;
        this.weight = weight;
    }

    @Override
    public void run() {
        Ferry ferry = Ferry.getInstance();
        ferry.addCar(this);
    }

    public TypeCar getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(TypeCar typeCar) {
        this.typeCar = typeCar;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public long getIdCar() {
        return idCar;
    }

    public void setIdCar(long idCar) {
        this.idCar = idCar;
    }
}
