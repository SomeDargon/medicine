package com.medicine.domain.dtoAndFrom.menu;

import com.medicine.domain.menu.PlatformManager;
import com.medicine.domain.menu.PlatformManagerData;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

/**
 * 中医疾病管理
 */
@Getter
@Setter
public class CdmManager extends SuperManager {
    private String bx;
    private String by;
    private String bzyd;
    private String fxlz;
    private String gk;
    private String glzh;
    private String glzz;
    private Integer isMenu;
    private String jbzd;
    private String ldyjls;
    private String qt;
    private String xgyxjb;
    private String zdyd;
    private String zgyh;
    private String zlyz;

    @Override
    public  SuperManager platformToCdmManagerConvert(PlatformManager platformManager, PlatformManagerData platformManagerData) {
        CdmManager cdmManager = new CdmManager();
        BeanUtils.copyProperties(platformManager, cdmManager);
        cdmManager.setKey(platformManager.getId());
        cdmManager.setSysType(platformManager.getMenuType());
        cdmManager.setBx(platformManagerData.getX1());
        cdmManager.setBy(platformManagerData.getX2());
        cdmManager.setBzyd(platformManagerData.getX3());
        cdmManager.setFxlz(platformManagerData.getX4());
        cdmManager.setGk(platformManagerData.getX5());
        cdmManager.setGlzh(platformManagerData.getX6());
        cdmManager.setGlzz(platformManagerData.getX7());
        cdmManager.setJbzd(platformManagerData.getX8());
        cdmManager.setLdyjls(platformManagerData.getX9());
        cdmManager.setQt(platformManagerData.getX10());
        cdmManager.setXgyxjb(platformManagerData.getX11());
        cdmManager.setZdyd(platformManagerData.getX12());
        cdmManager.setZgyh(platformManagerData.getX13());
        cdmManager.setZlyz(platformManagerData.getX14());
        return cdmManager;
    }

    @Override
    public  PlatformManagerData managerToPlatformConvertData(SuperManager superManager) {
        CdmManager cdmManager = (CdmManager)superManager;
        PlatformManagerData platformManagerData = new PlatformManagerData();
        platformManagerData.setX1(cdmManager.getBx());
        platformManagerData.setX2(cdmManager.getBy());
        platformManagerData.setX3(cdmManager.getBzyd());
        platformManagerData.setX4(cdmManager.getFxlz());
        platformManagerData.setX5(cdmManager.getGk());
        platformManagerData.setX6(cdmManager.getGlzh());
        platformManagerData.setX7(cdmManager.getGlzz());
        platformManagerData.setX8(cdmManager.getJbzd());
        platformManagerData.setX9(cdmManager.getLdyjls());
        platformManagerData.setX10(cdmManager.getQt());
        platformManagerData.setX11(cdmManager.getXgyxjb());
        platformManagerData.setX12(cdmManager.getZdyd());
        platformManagerData.setX13(cdmManager.getZgyh());
        platformManagerData.setX14(cdmManager.getZlyz());
        return platformManagerData;
    }
}
