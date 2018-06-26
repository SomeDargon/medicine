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

    private String name;

    @OneToMany(mappedBy = "western", cascade = CascadeType.ALL)
    private List<Image> img;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dOfWe_id")
    private DiagnosisOfWe dOfWe;

}
