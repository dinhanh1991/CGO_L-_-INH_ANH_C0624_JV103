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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String toString() {
        return name + " (" + country + ")";
    }
}
