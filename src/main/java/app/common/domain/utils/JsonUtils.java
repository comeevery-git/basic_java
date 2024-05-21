package app.common.domain.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtils {
    private final ObjectMapper objectMapper;

    public String readJson(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(getClass().getResource(filePath).toURI())));
        } catch (IOException | URISyntaxException e) {
            log.error("readJson error: ", e.getMessage());
            return null;
        }
    }

    public JsonUtils() {
        objectMapper = new ObjectMapper();

        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public String objectToJson(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    public <T> T jsonToObject(String json, Class<T> valueType) throws JsonProcessingException {
        return objectMapper.readValue(json, valueType);
    }

}
