package com.andywooh.utils.jao;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

public class JAOUtil {
	private static final ObjectMapper MAPPER = new ObjectMapper();

	private JAOUtil() {

	}

    public static <T> String objectToJson(T t) {
        StringWriter writer = new StringWriter();
        try {
            MAPPER.writeValue(writer, t);
        } catch (Exception e) {
            throw new IllegalStateException("Parse object to JSON failed", e);
        }
        return writer.toString();
    }

    public static <T> T jsonToObject(String jsonString, Class<T> valueType) {
        try {
            return MAPPER.readValue(jsonString, valueType);
        } catch (Exception e) {
            throw new IllegalStateException("Parse JSON to object failed", e);
        }

    }

    public static <T> List<T> jsonToList(String jsonString, Class<T> valueType) {
        JavaType type = MAPPER.getTypeFactory().constructCollectionType(List.class, valueType);
        try {
            return MAPPER.readValue(jsonString, type);
        } catch (IOException e) {
            throw new IllegalStateException("Parse object to List failed", e);
        }
    }

    public static <K, V> Map<K, V> jsonToMap(String jsonString, Class<K> keyType, Class<V> valueType) {
        JavaType type = MAPPER.getTypeFactory().constructMapType(Map.class, keyType, valueType);
        try {
            return MAPPER.readValue(jsonString, type);
        } catch (IOException e) {
            throw new IllegalStateException("Parse object to List failed", e);
        }
    }

    public static JsonNode jsonToJsonNode(String jsonString) {
        try {
            return MAPPER.readTree(jsonString);
        } catch (IOException e) {
            throw new IllegalStateException("Parse object to JsonNode failed", e);
        }
    }

    public static Object jsonNodeToObject(JsonNode j){
        return MAPPER.convertValue(j, Object.class);
    }
}
