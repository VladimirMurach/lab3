package lab3;

import java.util.ArrayList;

public class Reactor {
    
    private String name;
    private ReactorType type;
    private String country;
    private String operator;
    private String owner;
    private int thermalCapacity;
    private String region;
    private ArrayList<Double> loadFactor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ReactorType getType() {
        return type;
    }

    public void setType(ReactorType type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getThermalCapacity() {
        return thermalCapacity;
    }

    public void setThermalCapacity(int thermalCapacity) {
        this.thermalCapacity = thermalCapacity;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public ArrayList<Double> getLoadFactor() {
        return loadFactor;
    }

    public void setLoadFactor(ArrayList<Double> loadFactor) {
        this.loadFactor = loadFactor;
    }
    
    
}
