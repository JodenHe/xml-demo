package com.sindy.xml.utils;

import com.sindy.xml.utils.xstream.XStreamUtil;
import com.sindy.xml.utils.xstream.converter.XmlDateConverter;
import com.sindy.xml.utils.xstream.converter.XmlLongConverter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.List;
import java.util.stream.Collectors;

/**
 * xml 工具类
 * @author joden
 * <br>
 * created by xiaofeng.he on 2021/11/06
 */
public class XmlUtil {

    /**
     * 转换 list
     * @param xml
     * @param node
     * @param clazz
     * @param <T>
     * @return
     * @throws DocumentException
     */
    public static <T> List<T> toList(String xml, String node, Class<T> clazz) throws DocumentException {
        XStream xStream = XStreamUtil.newXStream();
        xStream.registerConverter(new XmlLongConverter());
        xStream.registerConverter(new XmlDateConverter());
        xStream.processAnnotations(clazz);
        xStream.addPermission(AnyTypePermission.ANY);


        Document document = DocumentHelper.parseText(xml);
        Element rootElement = document.getRootElement();
        List<Element> nodes = rootElement.elements(node);

        List<T> list =  nodes.stream()
                .map(e -> (T)xStream.fromXML(e.asXML()))
                .collect(Collectors.toList());

        return list;
    }


}
