package com.medicine.domain.queryFrom;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YanQueryFrom {

    private String name;

    /** 处方名称 */
    private String zfm;

    /** 西医疾病 */
    private String xyjb;

    /** 中医疾病 */
    private String zyjb;

    /** 中医证候 */
    private String zyzh;

    /** 中医症状 */
    private String zhenzhuang;

    /** 处方医师 */
    private String doctor;
}
