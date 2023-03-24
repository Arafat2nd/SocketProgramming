import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonReader {

    public static String readJson(String ID) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/cars.json"));
        JsonElement root = JsonParser.parseReader(reader);
        JsonElement car = root.getAsJsonObject().get(ID);
        return car == null ? "Vehicle is not found" : car.toString();

    }
}
