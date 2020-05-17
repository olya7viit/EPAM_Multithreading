package by.matusevich.multithreading.entity;

public enum TypeCar {

    PASSENGER(10,1),
    CARGO(15,5);

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
