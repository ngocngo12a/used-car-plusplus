package vn.plusplus.used.car.model;

public class Car {
    private String Name;
    private String image;
    private Float price;
    private String description ;
    private String sellerPhone;
    private String maker;
    private Integer year;
    private String status;
    private String fuel;
    private String color;
    private String models;
    private Integer odo;
    private Integer numberOfSeats;

    public Car() {
    }

    public Car(String name, String image, Float price, String description, String sellerPhone, String maker, Integer year, String status, String fuel, String color, String models, Integer odo, Integer numberOfSeats) {
        Name = name;
        this.image = image;
        this.price = price;
        this.description = description;
        this.sellerPhone = sellerPhone;
        this.maker = maker;
        this.year = year;
        this.status = status;
        this.fuel = fuel;
        this.color = color;
        this.models = models;
        this.odo = odo;
        this.numberOfSeats = numberOfSeats;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSellerPhone() {
        return sellerPhone;
    }

    public void setSellerPhone(String sellerPhone) {
        this.sellerPhone = sellerPhone;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModels() {
        return models;
    }

    public void setModels(String models) {
        this.models = models;
    }

    public Integer getOdo() {
        return odo;
    }

    public void setOdo(Integer odo) {
        this.odo = odo;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
