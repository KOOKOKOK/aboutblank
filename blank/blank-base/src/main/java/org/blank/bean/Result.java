package org.blank.bean;

import lombok.Data;

/**
 * 数据传输对象（DTO, Data Transfer Object）
 * @param <T>
 */
@Data
public class Result<T> extends BaseBean{
    private boolean success;
    private String message;
    private T data;

    public Result() {
    }

    /**
     *
     * @param success ajax 对应 的请求失败与成功
     * @param message 额外信息
     * @param data 前端数据
     */
    public Result(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
}
