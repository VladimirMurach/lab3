package lab3;

import java.io.File;
import java.util.ArrayList;

public class JsonHandler extends Handler {

    private JsonReader reader = new JsonReader();

    @Override
    public ArrayList<ReactorType> handle(File file) {
        if (findExtension(file).equals(".json")) {
            return reader.read(file);
        } else if (next != null) {
            return next.handle(file);
        } else {
            return null;
        }
    }
}
