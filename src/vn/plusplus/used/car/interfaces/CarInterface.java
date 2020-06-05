package vn.plusplus.used.car.interfaces;

import vn.plusplus.used.car.model.Car;

import java.util.List;

public interface CarInterface {
    void saveCarToDatabase(List<Car> carList);
    List<Car> readAllCarFromDatabase(String filePath);
    List<Car> findCarByPrice(Float priceFrom, Float priceTo);
    List<Car> findCarByMakerOrderByPriceDesc(String maker);
    List<Car> findCarByYear(Float year);
}
