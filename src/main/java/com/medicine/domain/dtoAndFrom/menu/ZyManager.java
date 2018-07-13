package com.medicine.domain.dtoAndFrom.menu;


import com.medicine.domain.menu.PlatformManager;
import com.medicine.domain.menu.PlatformManagerData;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class ZyManager extends SuperManager {

    private String bz;
    private String pzff;
    private String ycbw;
    private String zyc;


    @Override
    public SuperManager platformToCdmManagerConvert(PlatformManager platformManager, PlatformManagerData platformManagerData) {
        ZyManager zyManager = new ZyManager();
        BeanUtils.copyProperties(platformManager, zyManager);
        zyManager.setKey(platformManager.getId());
        zyManager.setBz(platformManagerData.getX1());
        zyManager.setPzff(platformManagerData.getX2());
        zyManager.setYcbw(platformManagerData.getX3());
        zyManager.setZyc(platformManagerData.getX4());
        return zyManager;
    }

    @Override
    public PlatformManagerData managerToPlatformConvertData(SuperManager superManager) {
        ZyManager zyManager = (ZyManager) superManager;
        PlatformManagerData platformManagerData = new PlatformManagerData();
        platformManagerData.setX1(zyManager.getBz());
        platformManagerData.setX2(zyManager.getPzff());
        platformManagerData.setX3(zyManager.getYcbw());
        platformManagerData.setX4(zyManager.getZyc());
        return platformManagerData;
    }
}
