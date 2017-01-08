package net.habashi.playgrounds.primefaces.customfilter.cars.model;

public class Car {

    private String brand;

    private String year;

    private Color color;

    public Car(String brand, String year, Color color) {
        this.brand = brand;
        this.year = year;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!brand.equals(car.brand)) return false;
        if (!year.equals(car.year)) return false;
        return color == car.color;
    }

    @Override
    public int hashCode() {
        int result = brand.hashCode();
        result = 31 * result + year.hashCode();
        result = 31 * result + color.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", year='" + year + '\'' +
                ", color=" + color +
                '}';
    }
}
