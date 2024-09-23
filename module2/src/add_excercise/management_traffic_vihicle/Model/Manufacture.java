package add_excercise.management_traffic_vihicle.Model;

public class Manufacture {
    private String code;
    private String name;
    private String country;

    public Manufacture() {
    }

    public Manufacture(String code, String name, String country) {
        this.code = code;
        this.name = name;
        this.country = country;
    }
    public String toString() {
        return name + " (" + country + ")";
    }
}
