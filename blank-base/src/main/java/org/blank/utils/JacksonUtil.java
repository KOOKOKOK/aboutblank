package org.blank.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class JacksonUtil {
    private ObjectMapper objectMapper;

    /**
     * 配置忽略json对应java对象不存在的字段
     * LocalDateTime 类的 JSON 反序列化会遇到报错,添加响应的数据绑定支持包,pom
     */
    public JacksonUtil() {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.findAndRegisterModules();
    }

    public <T extends Serializable>String javaBeanToJson(T obj)   {

        String jsonStr = null;
        try {
            jsonStr = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return jsonStr;
    }

    public <T extends Serializable> String javaBeanToJson(List<T> obj)  {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = null;
        try {
            jsonStr = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return jsonStr;
    }

    public <K extends Serializable,V extends Serializable> String javaBeanToJson(Map<K,V> obj)  {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = null;
        try {
            jsonStr = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return jsonStr;
    }

    public <T> T jsonToJavaBean(String jsonStr,Class<T> valueType)   {
        //language=JSON
        ObjectMapper objectMapper = new ObjectMapper();
        T obj = null;
        try {
            obj = objectMapper.readValue(jsonStr, valueType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }



}
