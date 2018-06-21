package com.medicine.domain.attiendRecode;

import com.medicine.domain.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

/**
 *
 */
@Data
@Entity
@Table(name = "western_medicine")
public class WesternMedicine extends BaseEntity {

    private String text;

    private Integer type;

    @OneToMany(mappedBy = "western", fetch = FetchType.LAZY)
    private List<Image> image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dOfWe_id")
    private DiagnosisOfWe dOfWe;

    @OneToOne(mappedBy = "shezhenimg")
    private DiagnosisOfZh dOfZh;
}
