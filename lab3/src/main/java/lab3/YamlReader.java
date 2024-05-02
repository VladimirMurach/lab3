package lab3;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;

class YamlReader implements Reader {

    @Override
    public ArrayList<ReactorType> read(File file) {

        ArrayList<ReactorType> reactorTypes = new ArrayList<>();
        try {
            Yaml yaml = new Yaml();
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(file.getName());
            Iterable<Object> documents = yaml.loadAll(inputStream);
            for (Object document : documents) {
                Map<String, Object> obj = (Map<String, Object>) document;
                ReactorType reactor = new ReactorType();
                for (String key : obj.keySet()) {
                    reactor.setType((String) obj.get("type"));
                    reactor.setBurnup((double) obj.get("burnup"));
                    reactor.setKpd((double) obj.get("kpd"));
                    reactor.setEnrichment((double) obj.get("enrichment"));
                    reactor.setThermalCapacity((int) obj.get("thermalCapacity"));
                    reactor.setElectricalCapacity((double) obj.get("electricalCapacity"));
                    reactor.setLifeTime((int) obj.get("lifeTime"));
                    reactor.setFirstLoad((double) obj.get("firstLoad"));
                    reactor.setSource("From YAML");
                }
                reactorTypes.add(reactor);
            }
            System.out.println("YAML успешно прочитан");
        } catch (org.yaml.snakeyaml.error.YAMLException ex) {
            System.out.println("Ошибка");
        }
        return reactorTypes;
    }
}
