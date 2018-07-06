package com.medicine.domain.dtoAndFrom.menu;

import com.medicine.domain.menu.PlatformManager;
import com.medicine.domain.menu.PlatformManagerData;
import com.medicine.domain.menu.Prescription;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Getter
@Setter
public class FjManager extends SuperManager {
    private String bz;
    private String cd;
    private String cfly;
    private String cfys;
    private String fjgx;
    private String fjlx;
    private String fjmz;
    private String fjzz;
    private String gytj;
    private String jfff;
    private String jx;
    private String syzh;
    private String zymc;
    private String zyyf;
    private String zyyl;
    private String zyzy;
    private String zyzz;
    private String zzxyjb;
    private String zzzyjb;
    private List<Prescription> cf;

    public SuperManager platformToCdmManagerConvert(PlatformManager platformManager, PlatformManagerData platformManagerData, List<Prescription> prescriptions) {
        FjManager fjManager = new FjManager();
        BeanUtils.copyProperties(platformManager, fjManager);
        fjManager.setCf(prescriptions);
        fjManager.setKey(platformManager.getId());
        fjManager.setSysType(platformManager.getMenuType());
        fjManager.setBz(platformManagerData.getX1());
        fjManager.setCd(platformManagerData.getX2());
        fjManager.setCfly(platformManagerData.getX3());
        fjManager.setCfys(platformManagerData.getX4());
        fjManager.setFjgx(platformManagerData.getX5());
        fjManager.setFjlx(platformManagerData.getX6());
        fjManager.setFjmz(platformManagerData.getX7());
        fjManager.setFjzz(platformManagerData.getX8());
        fjManager.setGytj(platformManagerData.getX9());
        fjManager.setJfff(platformManagerData.getX10());
        fjManager.setJx(platformManagerData.getX11());
        fjManager.setSyzh(platformManagerData.getX12());
        fjManager.setZymc(platformManagerData.getX13());
        fjManager.setZyyf(platformManagerData.getX14());
        fjManager.setZyyl(platformManagerData.getX15());
        fjManager.setZyzy(platformManagerData.getX16());
        fjManager.setZyzz(platformManagerData.getX17());
        fjManager.setZzxyjb(platformManagerData.getX18());
        fjManager.setZzzyjb(platformManagerData.getX19());
        return fjManager;
    }

    @Override
    public PlatformManagerData managerToPlatformConvertData(SuperManager superManager) {
        FjManager fjManager = (FjManager) superManager;
        PlatformManagerData platformManagerData = new PlatformManagerData();
        platformManagerData.setX1(fjManager.getBz());
        platformManagerData.setX2(fjManager.getCd());
        platformManagerData.setX3(fjManager.getCfly());
        platformManagerData.setX4(fjManager.getCfys());
        platformManagerData.setX5(fjManager.getFjgx());
        platformManagerData.setX6(fjManager.getFjlx());
        platformManagerData.setX7(fjManager.getFjmz());
        platformManagerData.setX8(fjManager.getFjzz());
        platformManagerData.setX9(fjManager.getGytj());
        platformManagerData.setX10(fjManager.getJfff());
        platformManagerData.setX11(fjManager.getJx());
        platformManagerData.setX12(fjManager.getSyzh());
        platformManagerData.setX13(fjManager.getZymc());
        platformManagerData.setX14(fjManager.getZyyf());
        platformManagerData.setX15(fjManager.getZyyl());
        platformManagerData.setX16(fjManager.getZyzy());
        platformManagerData.setX17(fjManager.getZyzz());
        platformManagerData.setX18(fjManager.getZzxyjb());
        platformManagerData.setX19(fjManager.getZzzyjb());
        return platformManagerData;
    }

}
