package com.novatus.examples.slack.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.mashape.unirest.http.Unirest;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * Object mapper for Unirest using Jackson
 */
@Component
public class JacksonUnirestMapper implements com.mashape.unirest.http.ObjectMapper {

    private com.fasterxml.jackson.databind.ObjectMapper jackson
        = new com.fasterxml.jackson.databind.ObjectMapper();

    /**
     * Constructor.
     */
    public JacksonUnirestMapper() {
        jackson.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        jackson.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        jackson.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * Read a JSON string into a type.
     *
     * @param value     The JSON string
     * @param valueType The class of the result
     * @param <T>       The type of the result
     * @return The result of type T
     */
    public <T> T readValue(String value, Class<T> valueType) {
        try {
            return jackson.readValue(value, valueType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Convert an object into a json string.
     *
     * @param value An object
     * @return a JSON string
     */
    public String writeValue(Object value) {
        try {
            return jackson.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Make unirest use this object mapper.
     */
    @PostConstruct
    public void initialize() {
        Unirest.setObjectMapper(this);
    }
}
