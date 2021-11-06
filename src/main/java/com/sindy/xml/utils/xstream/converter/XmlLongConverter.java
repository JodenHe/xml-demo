package com.sindy.xml.utils.xstream.converter;

import com.thoughtworks.xstream.converters.basic.LongConverter;

/**
 * xml long 转换
 * @author joden
 * <br>
 * created by xiaofeng.he on 2021/11/06
 */
public class XmlLongConverter extends LongConverter {

    @Override
    public Object fromString(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return Long.decode(str);
    }
}
