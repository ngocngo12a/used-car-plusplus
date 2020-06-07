package vn.plusplus.used.car.interfaces;

import vn.plusplus.used.car.model.Car;

import java.util.List;

public abstract class CarInterface {
    public abstract void saveCarToDatabase(List<Car> carList);
    public abstract List<Car> readAllCarFromDatabase(String filePath);
    public abstract List<Car> findCarByPrice(Float priceFrom, Float priceTo);
    public abstract List<Car> findCarByMakerOrderByPriceDesc(String maker);
    public abstract List<Car> findCarByYear(Float year);
}
