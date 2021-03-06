package vn.plusplus.used.car.interfaces;

import vn.plusplus.used.car.model.Car;

import java.util.List;

public interface CarInterface {
    void writeCarToFile(Car car);
    List<Car> readAllCarFromDatabase();
    List<Car> findCarByPrice(Float priceFrom, Float priceTo);
    List<Car> findCarByMakerOrderByPriceDesc(String maker);
    List<Car> findCarByYear(Integer year);

    void displayCar(List<Car> cars);
}
