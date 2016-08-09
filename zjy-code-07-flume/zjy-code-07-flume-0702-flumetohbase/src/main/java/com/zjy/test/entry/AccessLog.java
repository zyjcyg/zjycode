package com.zjy.test.entry;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjylllf
 * Date: 2016/7/29
 * Time: 17:52
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class AccessLog {

    private String clientIp;

    private String clientIndentity;

    private String remoteUser;

    private String dateTime;

    private String request;

    private String httpStatusCode;

    private String bytesSent;

    private String referer;

    private String userAgent;

    public String getClientIp() {

        return clientIp;

    }

    public void setClientIp(String clientIp) {

        this.clientIp = clientIp;

    }

    public String getClientIndentity() {

        return clientIndentity;

    }

    public void setClientIndentity(String clientIndentity) {

        this.clientIndentity = clientIndentity;

    }

    public String getRemoteUser() {

        return remoteUser;

    }

    public void setRemoteUser(String remoteUser) {

        this.remoteUser = remoteUser;

    }

    public String getDateTime() {

        return dateTime;

    }

    public void setDateTime(String dateTime) {

        this.dateTime = dateTime;

    }

    public String getRequest() {

        return request;

    }

    public void setRequest(String request) {

        this.request = request;

    }

    public String getHttpStatusCode() {

        return httpStatusCode;

    }

    public void setHttpStatusCode(String httpStatusCode) {

        this.httpStatusCode = httpStatusCode;

    }

    public String getBytesSent() {

        return bytesSent;

    }

    public void setBytesSent(String bytesSent) {

        this.bytesSent = bytesSent;

    }

    public String getReferer() {

        return referer;

    }

    public void setReferer(String referer) {

        this.referer = referer;

    }

    public String getUserAgent() {

        return userAgent;

    }

    public void setUserAgent(String userAgent) {

        this.userAgent = userAgent;

    }


}
