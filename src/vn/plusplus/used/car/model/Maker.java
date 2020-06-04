package vn.plusplus.used.car.model;

public class Maker {
    private String name;
    private String logo;

    public Maker() {
    }

    public Maker(String name, String logo) {
        this.name = name;
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
