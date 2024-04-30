package labs.lab3;

import java.io.File;
import java.util.ArrayList;

public class Manager {
    private Storage storage;
    
    public void importFile(File file) {
        //storage.setReactorTypes(reactorTypes);
    }

    public ArrayList<ReactorType> getReactorTypes() {
        return storage.getReactorTypes();
    }
}
