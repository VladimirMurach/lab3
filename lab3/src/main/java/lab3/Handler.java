package lab3;

import java.io.File;
import java.util.ArrayList;

public class Handler {

    private Handler next;
    private String readerExtension;
    private Reader reader;

    public Handler(String readerExtension, Reader reader) {
        this.readerExtension = readerExtension;
        this.reader = reader;
    }
    
    public void setNext(Handler next) {
        this.next = next;
    }
    
    private String findExtension(File file) {
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf('.');
        String extension = (dotIndex == -1) ? "" : fileName.substring(dotIndex);
        return extension;
    }

    public ArrayList<ReactorType> handle(File file) {
        if (findExtension(file).equals(readerExtension)) {
            return reader.read(file);
        } else if (next != null) {
            return next.handle(file);
        } else {
            return null;
        }
    }
}
