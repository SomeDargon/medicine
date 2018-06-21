package com.medicine.domain.attiendRecode;

import com.medicine.domain.BaseEntity;
import com.medicine.domain.attiendRecode.WesternMedicine;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Image extends BaseEntity {

    private String name;

    private String status;

    private String url;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "western_id")
    private WesternMedicine western;
}
