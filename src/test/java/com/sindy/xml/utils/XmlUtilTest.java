package com.sindy.xml.utils;

import org.dom4j.DocumentException;
import org.junit.Test;

import java.util.List;

public class XmlUtilTest {

    @Test
    public void toList() throws DocumentException {
        List<A> list = XmlUtil.toList(xml(), "ROW", A.class);
        System.out.println(list);
    }

    private static String xml() {
        return "<DATA>\n" +
                "    <ROW>\n" +
                "        <ID>1</ID>\n" +
                "        <NAME>joden</NAME>\n" +
                "        <AGE>18</AGE>\n" +
                "        <BORN_DATE>2000-01-11 00:00:00</BORN_DATE>\n" +
                "        <DESCRIPTION>sindy 是不变的信仰</DESCRIPTION>\n" +
                "    </ROW>\n" +
                "    <ROW>\n" +
                "        <ID>2</ID>\n" +
                "        <NAME>sindy</NAME>\n" +
                "        <AGE>18</AGE>\n" +
                "        <BORN_DATE>2000-08-01 00:00:00</BORN_DATE>\n" +
                "        <DESCRIPTION>Take your passion and make it come true</DESCRIPTION>\n" +
                "    </ROW>\n" +
                "</DATA>";
    }

}