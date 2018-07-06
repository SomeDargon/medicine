package com.medicine.domain.menu;

import com.medicine.domain.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "prescription")
public class Prescription extends BaseEntity{
    private Long menuId;
    private String name;
    private String yl;
    private String zy;
    private String yf;
}
