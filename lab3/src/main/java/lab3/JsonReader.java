package lab3;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class JsonReader implements Reader {

    @Override
    public ArrayList<ReactorType> read(File file) {

        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<ReactorType> reactorTypes = new ArrayList<>();
        try {
            reactorTypes = objectMapper.readValue(file,
                    objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, ReactorType.class));
            for (ReactorType reactorType : reactorTypes) {
                reactorType.setSource("From JSON");
            }
            System.out.println("JSON успешно прочитан");
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
        return reactorTypes;
    }
}
