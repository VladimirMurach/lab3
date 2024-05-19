package lab3;

import java.io.File;
import java.util.ArrayList;

public class Manager {

    private Storage storage = new Storage();
    private Calculator calculator = new Calculator();

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
            System.out.println(storage.getReactors().get(64).getFuelLoad());
        } else {
            System.out.println("Сначала прочитайте типы реакторов!");
        }
    }
}
