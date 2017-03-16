package com.lh.super_market.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

/**
 * Created by jia on 2015/7/10.
 */
public final class Jacksons {
	
	private static final Logger LOG = LoggerFactory.getLogger(Jacksons.class);

    public static String writeJson(Object object, final String... ignoreFields) {
        return writeJson(object, null, ignoreFields);
    }

    public static String writeJson(Object object, PropertyNamingStrategy namingStrategy, final String... ignoreFields) {
        ObjectMapper om = new ObjectMapper();
        om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        om.setAnnotationIntrospector(new JacksonAnnotationIntrospector() {
			private static final long serialVersionUID = 3816283136243101215L;
			@Override
            public String[] findPropertiesToIgnore(Annotated ac) {
                return ignoreFields;
            }
        });
        if (namingStrategy != null) {
            om.setPropertyNamingStrategy(namingStrategy);
        }
        try {
            return om.writeValueAsString(object);
        } catch (JsonProcessingException e) {
        	LOG.error(e.getMessage(), e);
            return null;
        }
    }

    public static <T> T readJson(String jsonString, Class<T> clazz) {
        return readJson(jsonString, null, clazz);
    }
    
    public static <T> T readJson(String jsonString, PropertyNamingStrategy namingStrategy, Class<T> clazz) {
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); 
        if (namingStrategy != null) {
            om.setPropertyNamingStrategy(namingStrategy);
        }
        try {
            return om.readValue(jsonString, clazz);
        } catch (IOException e) {
        	LOG.error(e.getMessage(), e);
            return null;
        }
    }
    
    public static <T> T readJson(String jsonString, TypeReference<T> typeRef) {
        return readJson(jsonString, null, typeRef);
    }
    
    public static <T> T readJson(String jsonString, PropertyNamingStrategy namingStrategy, TypeReference<T> typeRef) {
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); 
        if (namingStrategy != null) {
            om.setPropertyNamingStrategy(namingStrategy);
        }
        try {
            return om.readValue(jsonString, typeRef);
        } catch (IOException e) {
        	LOG.error(e.getMessage(), e);
            return null;
        }
    }


}
