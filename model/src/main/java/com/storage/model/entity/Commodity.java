package com.storage.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "t_sys_commodity")
public class Commodity implements Serializable {

    @Id
    private String id;

    private String code;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer number;

    @Column(name = "isValid")
    private String isvalid;

    @Column(name = "createdTime")
    private Date createdtime;

    @Column(name = "updateTime")
    private Date updatetime;

}