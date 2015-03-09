package com.core;

import javax.servlet.http.HttpServletRequest;

import com.jspsmart.upload.Request;


public class ParamUtils {

    public static String getParameter(HttpServletRequest request,
                                      String paramName) {
        return getParameter(request, paramName, false);
    }
    //读取传入的表单信息里的空字符串进行处理
    public static String getParameter(HttpServletRequest request,
                                      String paramName, String defaultStr) {
        String temp = request.getParameter(paramName);

        if (temp != null) {
            if (temp.equals("")) {
                return defaultStr;
            } else {
                return nullToString(temp);
            }
        } else {
            return defaultStr;
        }

    }

    public static String getEscapeHTMLParameter(HttpServletRequest request,//编写从表单获取的字符串的HTML标记替换为相应的HTML标记的方法。
                                                String paramName) {
        return nullToString(StringUtils.escapeHTMLTags(ParamUtils.getParameter(
            request, paramName, true)));
    }
    public static String getParameter(HttpServletRequest request,//编写对读取的表单信息后，对于空的或没有值得表单信息设置默认值
                                      String paramName, boolean emptyStringsOK) {
        String temp = request.getParameter(paramName);
        if (temp != null) {
            if (temp.equals("") && !emptyStringsOK) {
                return "";
            } else {
                return temp;
            }
        } else {
            return "";
        }
    }

    public static int getIntParameter(HttpServletRequest request,
                                      String paramName, int defaultNum) {
        String temp = request.getParameter(paramName);
        if (temp != null && !temp.equals("")) {
            int num = defaultNum;
            try {
                num = Integer.parseInt(temp);
            } catch (Exception ignored) {}
            return num;
        } else {
            return defaultNum;
        }
    }

    public static int getIntParameter(HttpServletRequest request,
                                      String paramName) {
        return getIntParameter(request, paramName, 0);
    }

    public static String nullToString(String oldString) {
        if (oldString == null) {
            return "";
        }
        return oldString;
    }
    public static String nullToString(String oldString,String defaultValue) {
        oldString=nullToString(oldString);
        if("".equals(oldString)){
            return defaultValue;
        }
        return oldString;
    }
//修改使用的方法
    public static String getRequestString(HttpServletRequest request,String s){	//主要为了调用前面方法
        s=nullToString(s).trim();
        s=ParamUtils.getEscapeHTMLParameter(request, s);
        s=StringUtils.toChinese(s);
        s=StringUtils.toUnicode(s);
        s=StringUtils.StringtoSql(s);
        return s;
    }
//添加使用的方法
    public static String getRequestString(Request request, String s) {	//编写对request信息进行处理的方法
        s=nullToString(s).trim();
        s=ParamUtils.getEscapeHTMLParameter(request, s);
        //转码
       // s=StringUtils.toChinese(s);
        s=StringUtils.toUnicode(s);
        s=StringUtils.StringtoSql(s);
        return s;
    }

    public static String getSqlString(String s){//对SQL字符串进行处理的方法
        s=StringUtils.SqltoString(s);
        s=StringUtils.toChinese(s);
        s=nullToString(s).trim();
        return s;
    }

    public static String getEscapeHTMLParameter(Request request, String s) {
        return nullToString(StringUtils.escapeHTMLTags(request.getParameter(s)));
    }

    public static int getIntParameter(Request request, String s) {//对于请求中的信息进行合法性的认证，不合法的会给予默认值
        int defaultNum=0;
        String temp = request.getParameter(s);
        if (temp != null && !temp.equals("")) {
            int num = defaultNum;
            try {
                num = Integer.parseInt(temp);
            } catch (Exception ignored) {}
            return num;
        } else {
            return defaultNum;
        }
    }
}
