package com.medicine.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "t_user")
@Entity
public class User extends BaseEntity{

    @Column(name = "user_name")
    private String userName;

    private String password;

    private String account;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "create_date")
    private Date createDate;

    private String icon;

}
