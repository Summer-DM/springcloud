package com.summer.springcloud.springcloudcommon.utils.modelUtils;

import com.alibaba.fastjson.JSONObject;
import com.summer.springcloud.springcloudcommon.utils.fileUtils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author Summer_DM
 * @Summary TODO  model实体类的一些校验和判断
 * @Version 1.0
 * @Date 2021/8/30 下午 05:09
 **/
public class CheckBean {

    private static  final Logger log = LoggerFactory.getLogger(CheckBean.class);
    /**
     * 判断实体类model属性是否为空？
     * 空（即null或者“”）：“”
     * 非空：get方法的值
     *
     * @param obj
     * @return  JSONObject
     */
    public static JSONObject getValue(Object obj) {
        JSONObject jsonObject = new JSONObject();
        try {
            // 获取类对象
            Class<? extends Object> c = obj.getClass();
            // 获取类属性
            Field[] fields = c.getDeclaredFields();
            // 得到方法体集合
            Method[] methods = c.getDeclaredMethods();
            // 遍历属性
            for (Field field : fields) {
                // 设置属性是可以访问的(私有的也可以)
                field.setAccessible(true);
                // 得到此属性的值
                Object val = field.get(obj);
                val = null == val || "".equals(val) ? "" : val;
                jsonObject.put(field.getName(), JSONObject.toJSONString(val));
            }
            System.out.println(jsonObject.toString());
            return jsonObject;

        } catch (Exception e) {
            e.printStackTrace();
            log.warn("判断对象是否为空出错：" + e.getMessage());
        }
        return null;

    }
}
