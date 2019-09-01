package com.jzheng.itoken.common.constants;

/**
 * Http 状态码 枚举
 * @author jzheng
 * @date 2019/8/30
 */
public enum HttpStatusConstants {

    /**
     * 服务器无法根据客户端的请求找到资源
     */
    Not_Found(404, "服务器无法根据客户端的请求找到资源"),

    /**
     * 充当网关或代理的服务器，从远端服务器接收到了一个无效的请求
     */
    Bad_Gateway(502, "充当网关或代理的服务器，从远端服务器接收到了一个无效的请求");

    /**
     * http 状态码
     */
    private int status;
    /**
     * 该状态码 对应的信息
     */
    private String content;

    HttpStatusConstants() {
    }

    HttpStatusConstants(int status, String content) {
        this.status = status;
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
