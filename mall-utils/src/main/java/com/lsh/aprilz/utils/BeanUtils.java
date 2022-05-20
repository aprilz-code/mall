package com.lsh.aprilz.utils;


import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author lsh
 * @TODO 对象工具类
 * @2021-9-28 上午10:28:33
 */

public class BeanUtils {

    public static void beanToMap(Object object, Map<String, Object> map) {

        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(object.getClass());
        } catch (IntrospectionException e1) {
            e1.printStackTrace();
        }
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            try {
                String key = property.getName();
                // 过滤class属性
                if (!key.equals("class")) {
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(object);
                    map.put(key, value);
                }
            } catch (Exception e) {
            }
        }
    }

    /**
     * 将map转化为bean
     *
     * @param map
     * @param objClass
     * @return
     */
    public static <T> T map2Bean(@SuppressWarnings("rawtypes") Map map, Class<T> objClass) {
        T t = null;
        try {
            t = objClass.newInstance();
            map2Bean(map, t, null);
        } catch (Exception e) {
        }
        return t;
    }

    /**
     * 将map转化为bean
     *
     * @param map
     * @param object
     * @param defultVal map里面get为null的就使用这个值
     */

    public static void map2Bean(@SuppressWarnings("rawtypes") Map map, Object object, Object defultVal) {
        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(object.getClass());
        } catch (IntrospectionException e1) {
            e1.printStackTrace();
        }
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            try {
                String key = property.getName();
                // 过滤class属性
                if (!key.equals("class")) {
                    Method setter = property.getWriteMethod();
                    Object val = map.get(key);
                    if (val == null) {
                        val = defultVal;
                    }
                    setter.invoke(object, val);
                }
            } catch (Exception e) {
            }
        }
    }


    /**
     * 根据导出层级，修改指定字段的注解@SensitiveWordsValid的name值
     *
     * @param detailClass 实体类
     * @param annotationClass 注解
     * @param attributeName 注解里的属性
     * @param value
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static void changeSWname(Class<?> detailClass, Class annotationClass, String attributeName, String value) throws NoSuchFieldException, IllegalAccessException {
        Field field = detailClass.getDeclaredField(attributeName);
        Annotation annotation = field.getAnnotation(annotationClass);
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(annotation);
        Field memberValues = invocationHandler.getClass().getDeclaredField("memberValues");
        memberValues.setAccessible(true);
        Map memberValuesMap = (Map) memberValues.get(invocationHandler);
        memberValuesMap.put("name", value);
    }

}
