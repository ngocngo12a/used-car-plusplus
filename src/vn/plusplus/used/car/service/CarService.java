package vn.plusplus.used.car.service;

import vn.plusplus.used.car.interfaces.CarInterface;
import vn.plusplus.used.car.model.Car;

import java.util.List;

public class CarService implements CarInterface {
    @Override
    public void saveCarToDatabase(List<Car> carList) {

    }

    @Override
    public List<Car> readAllCarFromDatabase(String filePath) {
        return null;
    }

    @Override
    public List<Car> findCarByPrice(Float priceFrom, Float priceTo) {
        return null;
    }

    @Override
    public List<Car> findCarByMakerOrderByPriceDesc(String maker) {
        return null;
    }

    @Override
    public List<Car> findCarByYear(Float year) {
        return null;
    }
}
