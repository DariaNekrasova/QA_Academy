package application.BE;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;

import java.io.IOException;

public class DtoUtils {

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static String toJSON(Object dto) {
        try {
            return OBJECT_MAPPER.writeValueAsString(dto);
        } catch (JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static String toJSONUsingView(Object dto, Class<?> view) {
        try {
            val mapper = new ObjectMapper();
            mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
            return mapper.writerWithView(view).writeValueAsString(dto);
        } catch (JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static <T> T toDto(String json, Class<T> dtoClass) {
        T dto = null;
        try {
            dto = OBJECT_MAPPER.readValue(json, dtoClass);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return dto;
    }
}