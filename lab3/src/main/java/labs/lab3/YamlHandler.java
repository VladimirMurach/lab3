package labs.lab3;

import java.io.File;
import java.util.ArrayList;

public class YamlHandler extends Handler {

    private YamlReader reader = new YamlReader();

    @Override
    public ArrayList<ReactorType> handle(File file) {
        if (findExtension(file).equals(".yaml")) {
            return reader.read(file);
        } else if (next != null) {
            return next.handle(file);
        } else {
            return null;
        }
    }
}
