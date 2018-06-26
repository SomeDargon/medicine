package com.medicine.domain.attiendRecode;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "western_id")
    @JsonIgnore
    private WesternMedicine western;
}
