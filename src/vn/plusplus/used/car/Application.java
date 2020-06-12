package vn.plusplus.used.car;

import vn.plusplus.used.car.model.Car;
import vn.plusplus.used.car.service.CarParser;
import vn.plusplus.used.car.service.CarService;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Xin moi lua chon tinh nang: ");
            System.out.println("1. Thu thap data");
            System.out.println("2. Tim kiem xe");
            System.out.println("3. Thoat chuong trinh");
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
                    break;
                case 2:
                    System.out.println("Nhập vào điều kiện bạn muốn tìm kiếm: ");
                    System.out.println("1. Tim theo nam san xuat" +
                            "\n2. Tim kiem theo khoang gia" +
                            "\n3. Tim kiem theo hang san xuat");
                    Integer findOption = scanner.nextInt();
                    if(findOption == 1){
                        System.out.println("Nhap vao nam san xuat muon tim kiem: ");
                        Integer year = scanner.nextInt();
                        List<Car> cars = carService.findCarByYear(year);
                        carService.displayCar(cars);
                    }
                    if(findOption == 2){
                        System.out.println("Nhap vao gia nho nhat: ");
                        Float fromPrice = scanner.nextFloat();
                        System.out.println("Nhap vao gia lon nhat: ");
                        Float toPrice = scanner.nextFloat();
                        List<Car> cars = carService.findCarByPrice(fromPrice, toPrice);
                        carService.displayCar(cars);
                    }
                    if(findOption == 3){
                        System.out.println("Nhap vao hang tim kiem: ");
                        String maker = scanner.nextLine();
                        List<Car> cars = carService.findCarByMakerOrderByPriceDesc(maker);
                        carService.displayCar(cars);
                    }
                    break;
                case 3:
                    return;
            }
        }
    }
}
