package com.sindy.xml.utils.xstream.converter;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.basic.DateConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * xml 日期转换器
 * @author joden
 * <br>
 * created by xiaofeng.he on 2021/11/06
 */
public class XmlDateConverter extends DateConverter {

    @Override
    public Object fromString(String str) {
        try {
            int index = str.indexOf("T");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Object result;
            int length = str.trim().length();
            if (index > 0) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
                result = formatter.parse(str.substring(0, 23));
            } else if (length == 19) {
                result = sdf.parse(str.substring(0, 19));
            } else {
                result =  super.fromString(str);
            }

            return result;
        } catch (ParseException e) {
            throw new ConversionException("Cannot parse date " + str);
        }
    }
}
