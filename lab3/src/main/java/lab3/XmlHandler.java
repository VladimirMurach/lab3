package lab3;

import java.io.File;
import java.util.ArrayList;

public class XmlHandler extends Handler {

    private MyXmlReader reader = new MyXmlReader();

    @Override
    public ArrayList<ReactorType> handle(File file) {
        if (findExtension(file).equals(".xml")) {
            return reader.read(file);
        } else if (next != null) {
            return next.handle(file);
        } else {
            return null;
        }
    }
}
