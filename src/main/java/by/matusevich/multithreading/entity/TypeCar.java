package by.matusevich.multithreading.entity;

public enum TypeCar {

    PASSENGER(10,5),
    CARGO(15,20);

    private double area;
    private double weight;

    TypeCar(double area, double weight) {
        this.area = area;
        this.weight = weight;
    }

    public double getArea() {
        return area;
    }

    public double getWeight() {
        return weight;
    }
}
