import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;

public class JsonDataBaseLoader implements DataBaseLoader {
    private ObjectMapper mapper = new ObjectMapper();

    /**
     * заполнение базы данных, загрузкой из json
     * @param path - путь файла json
     * @return - заполненная база данных
     */
    @Override
    @SneakyThrows
    public DataBase load(String path) {
        return mapper.readValue(new File(path), DataBase.class);
    }
}
