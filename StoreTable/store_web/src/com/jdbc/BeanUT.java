package com.jdbc;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class BeanUT {

    public static <T> T mapToBean(Map map, Class <T> c){
        try {
            T t = c.newInstance();
            BeanUtils.populate(t,map);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
