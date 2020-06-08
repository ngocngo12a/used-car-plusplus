package vn.plusplus.used.car;

import vn.plusplus.used.car.model.Car;
import vn.plusplus.used.car.service.CarParser;
import vn.plusplus.used.car.service.CarService;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Xin moi lua chon tinh nang: ");
        System.out.println("1. Thu thap data");
        System.out.println("2. Tim kiem xe");
        Integer option = scanner.nextInt();
        scanner.nextLine();

        CarParser carParser = new CarParser();
        CarService carService = new CarService();

        switch (option){
            case 1:
                System.out.println("Nhap vao link muon thu thap: ");
                String url = scanner.nextLine();
                List<Car> carList = carParser.parserAllcar(url);
                for(Car car: carList){
                    carService.writeCarToFile(car);
                }
        }

    }
}
