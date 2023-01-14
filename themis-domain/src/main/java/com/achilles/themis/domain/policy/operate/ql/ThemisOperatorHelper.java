package com.achilles.themis.domain.policy.operate.ql;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.achilles.themis.domain.entity.ThemisBaseNode;
import com.ql.util.express.exception.QLException;

import java.util.Objects;

public class ThemisOperatorHelper {

    public static void checkNodeExist(Object[] objects) throws QLException {
        for (Object object : objects) {
            if (Objects.isNull(object)) {
                throw new QLException("node is null!");
            }
        }
    }

    public static <T> T convert(Object object, Class<T> clazz) throws QLException {
        try {
            if (clazz.isAssignableFrom(object.getClass())) {
                if (clazz.equals(ThemisBaseNode.class)) {
                    ThemisBaseNode node = (ThemisBaseNode) object;
                    return (T) node.copy();
                } else {
                    return (T) object;
                }
            }
        } catch (Exception e) {
            throw new QLException("An error occurred while copying an object");
        }
        throw new QLException(StrUtil.format("The parameter must be {} item", clazz.getSimpleName()));
    }

    public static String createUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }




}
