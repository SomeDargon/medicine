package com.medicine.domain.dtoAndFrom.menu;

import com.medicine.domain.menu.PlatformManager;
import com.medicine.domain.menu.PlatformManagerData;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class WdmManager extends SuperManager {

    private String by;
    private String fbjz;
    private String gk;
    private String jb;
    private String jbzd;
    private String lhjc;
    private String tz;
    private String yh;

    @Override
    public  SuperManager platformToCdmManagerConvert(PlatformManager platformManager, PlatformManagerData platformManagerData) {
        WdmManager cdmManager = new WdmManager();
        BeanUtils.copyProperties(platformManager, cdmManager);
        return cdmManager;
    }

    @Override
    public  PlatformManagerData managerToPlatformConvertData(SuperManager superManager) {
        WdmManager wdmManager = (WdmManager) superManager;
        PlatformManagerData platformManagerData = new PlatformManagerData();
//        platformManagerData.setX1(cdmManager.getBx());
//        platformManagerData.setX2(cdmManager.getBy());
//        platformManagerData.setX3(cdmManager.getBzyd());
//        platformManagerData.setX4(cdmManager.getFxlz());
//        platformManagerData.setX5(cdmManager.getGk());
//        platformManagerData.setX6(cdmManager.getGlzh());
//        platformManagerData.setX7(cdmManager.getGlzz());
//        platformManagerData.setX8(cdmManager.getJbzd());
//        platformManagerData.setX9(cdmManager.getLdyjls());
//        platformManagerData.setX10(cdmManager.getQt());
//        platformManagerData.setX11(cdmManager.getXgyxjb());
//        platformManagerData.setX12(cdmManager.getZdyd());
//        platformManagerData.setX13(cdmManager.getZgyh());
//        platformManagerData.setX14(cdmManager.getZlyz());
        return platformManagerData;
    }

}
