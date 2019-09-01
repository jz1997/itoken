package com.jzheng.itoken.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

/**
 * json 工具类
 * @author jzheng
 * @date 2019/8/30
 */
public class MapperUtils {
    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * 获取 ObjectMapper 实例
     * @return ObjectMapper
     */
    public static ObjectMapper getInstance() {
        return OBJECT_MAPPER;
    }

    /**
     * object 转化成 json 字符串
     * @param object 对象
     * @return json 字符串
     * @throws JsonProcessingException 生成 json 异常
     */
    public static String object2Json(Object object) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsString(object);
    }

    /**
     * object 转化成 json 字符串，忽略空值
     * @param object 对象
     * @return json 字符串
     * @throws JsonProcessingException 生成 json 异常
     */
    public static String object2JsonIgnoreNull(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper.writeValueAsString(object);
    }

    /**
     * json 字符串转化成 pojo 对象
     * @param json json 字符串
     * @param clazz 对应对象的 class
     * @param <T> 泛型
     * @return json 所转化成的 bean 对象
     * @throws IOException
     */
    public static <T> T json2Pojo(String json, Class<T> clazz) throws IOException {
        OBJECT_MAPPER.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        return OBJECT_MAPPER.readValue(json, clazz);
    }

    /**
     * map 转化成 json 字符串
     * @param map map 对象
     * @return json 字符串
     */
    public static String map2Json(Map map) {
        try {
            return OBJECT_MAPPER.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 将 json 对象转化成 javaBean
     * @param object json 对象
     * @param clazz 目标 Bean 的 class
     * @param <T> 泛型
     * @return 目标类型对象
     */
    public static <T> T jsonObj2Pojo(Object object, Class<T> clazz) {
        return OBJECT_MAPPER.convertValue(object, clazz);
    }
}
