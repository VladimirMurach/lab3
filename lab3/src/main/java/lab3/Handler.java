package lab3;

import java.io.File;
import java.util.ArrayList;

public abstract class Handler {

    protected Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }
    
    protected String findExtension(File file) {
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf('.');
        String extension = (dotIndex == -1) ? "" : fileName.substring(dotIndex);
        return extension;
    }

    public abstract ArrayList<ReactorType> handle(File file);
}
