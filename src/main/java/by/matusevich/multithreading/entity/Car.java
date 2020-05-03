package by.matusevich.multithreading.entity;

public class Car {
    TypeCar typeCar;
    double area;
    double weight;

    public Car(TypeCar typeCar, double area, double weight) {
        this.typeCar = typeCar;
        this.area = area;
        this.weight = weight;
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
}
