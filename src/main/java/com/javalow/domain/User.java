package com.javalow.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * user_innodb
 *
 * @author
 */
@Data
public class User implements Serializable {

    private Integer id;

    private String name;

    private Boolean gender;

    private String phone;

    private static final long serialVersionUID = 1L;
}