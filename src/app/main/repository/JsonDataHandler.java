package app.main.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class JsonDataHandler {  //Generic json объектный сериализатор и десериализатор
    private final String FILE_NAME = "resources/company_data.json";
    private final Gson gson;
    private final File file;

    JsonDataHandler(){
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        file = new File(FILE_NAME);
    }

    public <T> void saveToJson(T data) {
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Невозможно создать файл: " + e);
            }
        }
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T loadFromJson(Class<T> tClass) {
        if(!file.exists())
            return null;

        try (FileReader reader = new FileReader(FILE_NAME)) {
            return gson.fromJson(reader, tClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}