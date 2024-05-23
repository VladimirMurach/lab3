package lab3;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class Manager {

    private Storage storage = new Storage();
    private Calculator calculator = new Calculator();
    private Aggregator aggregator = new Aggregator();

    public void importFile(File file) {

        Handler xmlHandler = new Handler(".xml", new MyXmlReader());
        Handler yamlHandler = new Handler(".yaml", new YamlReader());
        Handler jsonHandler = new Handler(".json", new JsonReader());
        xmlHandler.setNext(yamlHandler);
        yamlHandler.setNext(jsonHandler);
        storage.setReactorTypes(xmlHandler.handle(file));
    }

    public ArrayList<ReactorType> getReactorTypes() {
        return storage.getReactorTypes();
    }

    public void readDatabase() {
        DatabaseReader reader = new DatabaseReader();
        if (storage.getReactorTypes() != null) {
            storage.setReactors(reader.readDB(storage.getReactorTypes()));
            calculator.calculateFuelLoad(storage.getReactors());
        } else {
            System.out.println("Сначала прочитайте типы реакторов!");
        }
    }

    public Map<String, Map<Integer, Double>> aggregateByOperator() {
        if (storage.getReactors() != null) {
            return aggregator.aggregateByOperator(storage.getReactors());
        } else {
            System.out.println("Сначала прочитайте БД!");
            return null;
        }
    }

    public Map<String, Map<Integer, Double>> aggregateByCountry() {
        if (storage.getReactors() != null) {
            return aggregator.aggregateByCountry(storage.getReactors());
        } else {
            System.out.println("Сначала прочитайте БД!");
            return null;
        }
    }

    public Map<String, Map<Integer, Double>> aggregateByRegion() {
        if (storage.getReactors() != null) {
            return aggregator.aggregateByRegion(storage.getReactors());
        } else {
            System.out.println("Сначала прочитайте БД!");
            return null;
        }
    }
}
