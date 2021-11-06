package com.sindy.xml.utils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.Date;

@Data
@XStreamAlias("ROW")
public class A {

    @XStreamAlias("ID")
    private Long id;

    @XStreamAlias("NAME")
    private String name;

    @XStreamAlias("AGE")
    private Integer age;

    @XStreamAlias("BORN_DATE")
    private Date bornDate;

    @XStreamAlias("DESCRIPTION")
    private String description;
}
