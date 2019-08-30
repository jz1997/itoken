package com.jzheng.itoken.common.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author jzheng
 */
public class BaseResult implements Serializable {
    private static final String RESULT_OK = "ok";
    private static final String RESULT_NOT_OK = "not_ok";

    private static final String SUCCESS = "操作成功";

    /**
     * 操作结果
     */
    private String result;
    /**
     * data 返回的数据
     */
    private Object data;

    /**
     * success 返回成功信息
     */
    private String success;

    /**
     * 分页信息
     */
    private Cursor cursor;

    /**
     * 错误信息
     */
    private List<Error> errors;


    /**
     * 操作成功 有返回参数
     * @param data 返回的数据
     * @return baseResult
     */
    public static BaseResult ok(Object data) {
        return createBaseResult(RESULT_OK, data, SUCCESS, null, null);
    }

    /**
     * 操作成功 没有返回数据
     * @return baseResult
     */
    public static BaseResult ok() {
        return createBaseResult(RESULT_OK, null, SUCCESS, null, null);
    }

    /**
     * 操作失败
     * @param errors 错误信息
     * @return baseResult
     */
    public static BaseResult notOk(List<Error> errors) {
        return createBaseResult(RESULT_NOT_OK, null, "", null, errors);
    }

    /**
     * 创建 baseResult
     * @param result   结果 ok / not_ok
     * @param data     传回参数
     * @param success  成功信息
     * @param cursor   分页信息
     * @param errors   错误信息列表
     * @return baseResult
     */
    private static BaseResult createBaseResult(String result, Object data, String success, Cursor cursor, List<Error> errors) {
        BaseResult baseResult = new BaseResult();
        baseResult.setResult(result);
        baseResult.setData(data);
        baseResult.setCursor(cursor);
        baseResult.setSuccess(success);
        baseResult.setErrors(errors);
        return baseResult;
    }

    /**
     * 错误信息
     */
    public static class Error {
        /**
         * 错误字段
         */
        private String field;

        /**
         * 错误信息
         */
        private String message;

        public Error() {
        }

        public Error(String field, String message) {
            this.field = field;
            this.message = message;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    /**
     * 分页数据
     */
    public static class Cursor {
        /**
         * 数据总数
         */
        private int total;

        /**
         * 当前所在位置
         */
        private int offset;

        /**
         * 每页的条数
         */
        private int limit;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public Cursor getCursor() {
        return cursor;
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }
}
