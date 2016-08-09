package com.zjy.test.parser;

import com.zjy.test.entry.AccessLog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjylllf
 * Date: 2016/7/29
 * Time: 17:54
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */


public class AccessLogParser {

    /**
     * 日志格式
     * <p/>
     * 11.52.10.49 - - [17/Sep/2015:11:35:21 +0800] "GET /webapp HTTP/1.1" 302 - "-" "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.120 Safari/537.36"
     */

    private static String pattern = "^([\\d.]+) (\\S+) (\\S+) \\[([\\w:/]+\\s[+\\-]\\d{4})\\] \"(.+?)\" (\\d{3}) (\\d+|-) \"([^\"]+)\" \"([^\"]+)\"";

    private static Pattern p = Pattern.compile(pattern);

    public static AccessLog parse(String line) {

        Matcher matcher = p.matcher(line);
        if (matcher.matches()) {
            AccessLog accessLog = new AccessLog();
            accessLog.setClientIp(matcher.group(1));
            accessLog.setClientIndentity(matcher.group(2));
            accessLog.setRemoteUser(matcher.group(3));
            accessLog.setDateTime(matcher.group(4));
            accessLog.setRequest(matcher.group(5));
            accessLog.setHttpStatusCode(matcher.group(6));
            accessLog.setBytesSent(matcher.group(7));
            accessLog.setReferer(matcher.group(8));
            accessLog.setUserAgent(matcher.group(9));
            return accessLog;
        }
        return null;
    }
}