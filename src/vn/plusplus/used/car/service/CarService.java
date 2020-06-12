package vn.plusplus.used.car.service;

import vn.plusplus.used.car.interfaces.CarInterface;
import vn.plusplus.used.car.model.Car;
import vn.plusplus.used.car.service.CarParser;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CarService implements CarInterface {


    @Override
    public void writeCarToFile(Car car) {
        // Ghi File
        try {
            FileWriter fileWriter = null;
            BufferedWriter br = null;
            File file = new File("data/Car.txt");

            if(!file.exists()) {

                //Get current path of project in local computer
                Path currentRelativePath = Paths.get("");
                String s = currentRelativePath.toAbsolutePath().toString();

                //Create new file answer.txt with absoluatePath
                fileWriter = new FileWriter(s +"/data/Car.txt");
                br = new BufferedWriter(fileWriter);
                file.createNewFile();

                br.write(car.toString());
                br.newLine();
            }
        } catch (Exception e) {
            System.out.println("Lỗi ghi file");
        }

    }

    @Override
    public List<Car> readAllCarFromDatabase() {
        List<Car> carList = new ArrayList<>();
        String line ="";
        try {
            String filePath = "";
            FileReader f= new FileReader(filePath);
            BufferedReader file = new BufferedReader(f);
                while(true) {
                    line=file.readLine();
                    if (line == null){
                        break;
                    }
                    String[] str = line.split("###");
                        Car car = new Car();
                        car.setName(str[0].replace("Name=",""));
                        car.setImage(str[1].replace("image=",""));
                        car.setPrice((float) Integer.parseInt(str[2].replace("price=","")));
                        car.setDescription(str[3].replace("description=",""));
                        car.setSellerPhone(str[4].replace("sellerPhone=",""));
                        car.setMaker(str[5].replace("maker=",""));
                        car.setYear(Integer.parseInt(str[6].replace("year=","")));
                        car.setStatus(str[7].replace("status=",""));
                        car.setFuel(str[8].replace("fuel=",""));
                        car.setColor(str[9].replace("color=",""));
                        car.setModels(str[10].replace("models=",""));
                        car.setOdo(Integer.parseInt(str[11].replace("odo=","")));
                        car.setNumberOfSeats(Integer.parseInt(str[12].replace("numberOfSeats=","")));
                        carList.add(car);
                }

        } catch (Exception e) {
            System.out.println("Lỗi :"+e);
        }
        return carList;
    }

    @Override
    public List<Car> findCarByPrice(Float priceFrom, Float priceTo) {
        List<Car> cars = new ArrayList<>();
        List<Car> car = new ArrayList<>();
        cars = readAllCarFromDatabase();
        for (Car item: cars
             ) {
            if (item.getPrice()>= priceFrom && item.getPrice()<= priceTo ){
                car.add(item);
            }
        }
        return car;
    }

    @Override
    public List<Car> findCarByMakerOrderByPriceDesc(String maker) {
        return null;
    }

    @Override
    public List<Car> findCarByYear(Float year) {
            List<Car> cars = new ArrayList<>();
            List<Car> car = new ArrayList<>();
            cars = readAllCarFromDatabase();
            for(Car item : cars){
                if(item.getYear().equals(Integer.valueOf(String.valueOf(year)))){
                    car.add(item);
                }
            }
            return car;
    }
}
