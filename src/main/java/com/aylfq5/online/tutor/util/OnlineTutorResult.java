package com.aylfq5.online.tutor.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * @Description: 自定义结果集
 * @Author: aylfq5
 * @CreateDate: 2019/2/28 11:46
 * @Version: 1.0
 */
public class OnlineTutorResult {
    /**
     * 定义jackson对象
     */
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 响应业务状态
     */
    private Integer code;

    /**
     * 响应消息
     */
    private String msg;
    /**
     * 响应数据条数
     */
    private Integer count;
    /**
     * 响应中的数据
     */
    private Object data;


    public static OnlineTutorResult build(Integer status, String msg, Integer count, Object data) {
        return new OnlineTutorResult(status, msg, count, data);
    }

    public static OnlineTutorResult build(Integer status, String msg) {
        return new OnlineTutorResult(status, msg);
    }

    public static OnlineTutorResult ok(Object data) {
        return new OnlineTutorResult(data);
    }

    public static OnlineTutorResult ok() {
        return new OnlineTutorResult(null);
    }

    public OnlineTutorResult() {

    }

    public static OnlineTutorResult build(Integer status, String msg, Integer count) {
        return new OnlineTutorResult(status, msg, count, null);
    }

    public OnlineTutorResult(Integer code, String msg, Integer count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public OnlineTutorResult(Integer code, String msg) {
        this(code, msg, null, null);
    }

    public OnlineTutorResult(Object data) {
        this.code = 200;
        this.msg = "OK";
        this.data = data;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 将json结果集转化为TOnlineTutorResult对象
     *
     * @param jsonData json数据
     * @param clazz    OnlineTutorResult中的object类型
     * @return
     */
    public static OnlineTutorResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, OnlineTutorResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("code").intValue(), jsonNode.get("msg").asText(), jsonNode.get("count").intValue(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 没有object对象的转化
     *
     * @param json
     * @return
     */
    public static OnlineTutorResult format(String json) {
        try {
            return MAPPER.readValue(json, OnlineTutorResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     *
     * @param jsonData json数据
     * @param clazz    集合中的类型
     * @return
     */
    public static OnlineTutorResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("code").intValue(), jsonNode.get("msg").asText(), jsonNode.get("count").intValue(), obj);
        } catch (Exception e) {
            return null;
        }
    }
}
