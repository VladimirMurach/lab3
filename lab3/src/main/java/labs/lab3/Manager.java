package labs.lab3;

import java.io.File;
import java.util.ArrayList;

public class Manager {

    private Storage storage = new Storage();

    public void importFile(File file) {

        Handler xmlHandler = new XmlHandler();
        Handler yamlHandler = new YamlHandler();
        Handler jsonHandler = new JsonHandler();
        xmlHandler.setNext(yamlHandler);
        yamlHandler.setNext(jsonHandler);
        storage.setReactorTypes(xmlHandler.handle(file));
    }

    public ArrayList<ReactorType> getReactorTypes() {
        return storage.getReactorTypes();
    }
}
