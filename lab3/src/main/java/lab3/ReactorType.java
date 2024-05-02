package lab3;

public class ReactorType {
    
    private String type;
    private double burnup;
    private double kpd;
    private double enrichment;
    private int thermalCapacity;
    private double electricalCapacity;
    private int lifeTime;
    private double firstLoad;
    private String source;

    public String getType() {
        return type;
    }

    public double getBurnup() {
        return burnup;
    }

    public double getKpd() {
        return kpd;
    }

    public double getEnrichment() {
        return enrichment;
    }

    public int getThermalCapacity() {
        return thermalCapacity;
    }

    public double getElectricalCapacity() {
        return electricalCapacity;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public double getFirstLoad() {
        return firstLoad;
    }

    public String getSource() {
        return source;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBurnup(double burnup) {
        this.burnup = burnup;
    }

    public void setKpd(double kpd) {
        this.kpd = kpd;
    }

    public void setEnrichment(double enrichment) {
        this.enrichment = enrichment;
    }

    public void setThermalCapacity(int thermalCapacity) {
        this.thermalCapacity = thermalCapacity;
    }

    public void setElectricalCapacity(double electricalCapacity) {
        this.electricalCapacity = electricalCapacity;
    }

    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
    }

    public void setFirstLoad(double firstLoad) {
        this.firstLoad = firstLoad;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
