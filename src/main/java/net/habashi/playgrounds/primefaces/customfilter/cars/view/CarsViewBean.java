package net.habashi.playgrounds.primefaces.customfilter.cars.view;

import net.habashi.playgrounds.primefaces.customfilter.cars.model.Car;
import net.habashi.playgrounds.primefaces.customfilter.cars.model.Color;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean(name = "CarsViewBean")
@RequestScoped
public class CarsViewBean {

    private List<Car> cars = new ArrayList<>();

    private List<Car> filteredCars = new ArrayList<>();

    private String carsBrandFilterValue = "";

    @PostConstruct
    private void init() {
        cars = Arrays.asList(
                new Car("mercedes", "1987", Color.BLACK),
                new Car("renault", "2006", Color.WHITE),
                new Car("bmw", "1998", Color.RED),
                new Car("jaguar", "2001", Color.BLUE),
                new Car("smart", "2015", Color.PURPLE)
        );

        filteredCars = cars;
    }

    private List<Car> applyWildcardFilter(List<Car> filteredCars, String carsBrandFilterValue) {
        return filteredCars.stream().filter(car -> {
            String brand = car.getBrand();
            String wildcardFilterValue = carsBrandFilterValue.replace("*", ".*");
            return brand.matches(wildcardFilterValue);
        }).collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getFilteredCars() {
        return filteredCars;
    }

    public void setFilteredCars(List<Car> filteredCars) {
        if (carsBrandFilterValue != null && !carsBrandFilterValue.isEmpty() && filteredCars != null) {
            this.filteredCars = applyWildcardFilter(filteredCars, carsBrandFilterValue);
        } else {
            this.filteredCars = filteredCars;
        }
    }

    public String getCarsBrandFilterValue() {
        return carsBrandFilterValue;
    }

    public void setCarsBrandFilterValue(String carsBrandFilterValue) {
        this.carsBrandFilterValue = carsBrandFilterValue;
    }
}
