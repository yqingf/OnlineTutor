package com.aylfq5.online.tutor.util;

import org.apache.ibatis.javassist.*;
import org.apache.ibatis.javassist.bytecode.CodeAttribute;
import org.apache.ibatis.javassist.bytecode.LocalVariableAttribute;
import org.apache.ibatis.javassist.bytecode.MethodInfo;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/3/1 10:32
 * @Version: 1.0
 */
public class RequestUtil {

    private static final Logger logger = LoggerFactory.getLogger(RequestUtil.class);

    /**
     * 获取请求ip
     *
     * @param request
     * @return
     */
    public static String getRequestIp(HttpServletRequest request) {
        if (request == null) {
            throw new RuntimeException("HttpServletRequest对象为空");
        }
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        String[] arr = ip.split(",");
        for (String str : arr) {
            if (!"unknown".equalsIgnoreCase(str)) {
                ip = str;
                break;
            }
        }
        return ip;
    }

    /**
     * 获取请求方式：普通请求, ajax请求
     *
     * @param request
     * @return
     */
    public static Integer getRequestType(HttpServletRequest request) {
        if (request == null) {
            throw new RuntimeException("HttpServletRequest对象为空");
        }
        String type = request.getHeader("X-Requested-With");
        return type == null ? 1 : 2;
    }

    public static Map<String, Object> getJoinPointInfoMap(JoinPoint joinPoint) {
        Map<String, Object> joinPointInfo = new HashMap<>();
        String classpath = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        joinPointInfo.put("classpath", classpath);
        joinPointInfo.put("methodName", methodName);
        Class<?> clazz = null;
        CtMethod ctMethod = null;
        LocalVariableAttribute attr = null;
        int length = 0;
        int pos = 0;

        try {
            clazz = Class.forName(classpath);
            String clazzName = clazz.getName();
            ClassPool pool = ClassPool.getDefault();
            ClassClassPath classClassPath = new ClassClassPath(clazz);
            pool.insertClassPath(classClassPath);
            CtClass ctClass = pool.get(clazzName);
            ctMethod = ctClass.getDeclaredMethod(methodName);
            MethodInfo methodInfo = ctMethod.getMethodInfo();
            CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
            attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
            if (attr == null) {
                return joinPointInfo;
            }
            length = ctMethod.getParameterTypes().length;
            pos = Modifier.isStatic(ctMethod.getModifiers()) ? 0 : 1;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        Map<String, Object> paramMap = new HashMap<>();
        Object[] paramsArgsValues = joinPoint.getArgs();
        String[] paramsArgsNames = new String[length];
        for (int i = 0; i < length; i++) {
            paramsArgsNames[i] = attr.variableName(i + pos);
            String paramsArgsName = attr.variableName(i + pos);
            if (paramsArgsName.equalsIgnoreCase("request") ||
                    paramsArgsName.equalsIgnoreCase("response") ||
                    paramsArgsName.equalsIgnoreCase("session")) {
                break;
            }
            Object paramsArgsValue = paramsArgsValues[i];
            paramMap.put(paramsArgsName, paramsArgsValue);
        }
        joinPointInfo.put("paramMap", JsonUtils.objectToJson(paramMap));
        return joinPointInfo;
    }

    /**
     * 输出json信息
     *
     * @param response
     * @param build
     */
    public static void out(HttpServletResponse response, OnlineTutorResult build) {
        PrintWriter out = null;
        try {
            //设置编码
            response.setCharacterEncoding("UTF-8");
            //设置返回类型
            response.setContentType("application/json");
            out = response.getWriter();
            //输出
            out.println(JsonUtils.objectToJson(build));
            logger.info("【RequestUtils.out】响应json信息成功");
        } catch (Exception e) {
            logger.error("【RequestUtils.out】响应json信息出错", e);
        } finally {
            if (null != out) {
                out.flush();
                out.close();
            }
        }
    }
}
