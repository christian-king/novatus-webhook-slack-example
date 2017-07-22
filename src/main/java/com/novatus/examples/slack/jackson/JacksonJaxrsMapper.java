package com.novatus.examples.slack.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonJaxrsMapper extends ObjectMapper {

    /**
     * Configure a Jackson mapper for JAXRS.
     */
    public JacksonJaxrsMapper() {
        super();
        setSerializationInclusion(JsonInclude.Include.NON_NULL);
        configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

}
