package vn.plusplus.used.car.service;

import vn.plusplus.used.car.interfaces.CarInterface;
import vn.plusplus.used.car.model.Car;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class CarService implements CarInterface {


    @Override
    public void writeCarToFile(Car car) {
        FileWriter writer = null;
        PrintWriter buffer = null;
        String carStr = car.toString();
        try {
            File file;
            writer = new FileWriter("C:\\Users\\Phan Nho Hoang\\Desktop\\used-car-plusplus\\Car-data.txt", true);
            buffer = new PrintWriter(writer);
            buffer.println(carStr);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            writer.close();
            buffer.close();
        }

    }

//    @Override
//    public List<Car> readAllCarFromDatabase(String filePath) {
//        return null;
//    }
//
//    @Override
//    public List<Car> findCarByPrice(Float priceFrom, Float priceTo) {
//        return null;
//    }
//
//    @Override
//    public List<Car> findCarByMakerOrderByPriceDesc(String maker) {
//        return null;
//    }
//
//    @Override
//    public List<Car> findCarByYear(Float year) {
//        return null;
//    }
}
