package com.medicine.service.impl;

import com.alibaba.fastjson.JSON;
import com.medicine.common.constant.MenuStatus;
import com.medicine.domain.dtoAndFrom.menu.*;
import com.medicine.domain.menu.PlatformManager;
import com.medicine.domain.menu.PlatformManagerData;
import com.medicine.domain.menu.Prescription;
import com.medicine.domain.repository.menu.PlatformManagerDataRepository;
import com.medicine.domain.repository.menu.PlatformManagerRepository;
import com.medicine.domain.repository.menu.PrescriptionRepository;
import com.medicine.service.PlatformManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlatformManagerServiceImpl implements PlatformManagerService {

    @Autowired
    private PlatformManagerRepository platformManagerRepository;

    @Autowired
    private PlatformManagerDataRepository platformManagerDataRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Override
    public PlatformManager save(Map<String, Object> data) {
        String type = data.get("sysType").toString();
        String json = JSON.toJSONString(data, true);
        PlatformManager platformManager = new PlatformManager();
        switch (type) {
            case "cdm":return getPlatformRecord(json, CdmManager.class);
            case "wdm":return getPlatformRecord(json, WdmManager.class);
            case "zh":return getPlatformRecord(json, ZhManager.class);
            case "sz":return getPlatformRecord(json, SzManager.class);
            case "yp":return getPlatformRecord(json, YpManager.class);
            case "zy":return getPlatformRecord(json, ZyManager.class);
            case "zzzf":return getPlatformRecord(json, ZzzFmManager.class);
            case "mz":return getPlatformRecord(json, MzManager.class);
            case "gxlx":return getPlatformRecord(json, GxlxManager.class);
            case "fj":return getPlatformRecord(json, FjManager.class);
            case "fjzz":return getPlatformRecord(json, FjzzManager.class);
            case "zz":return getPlatformRecord(json, ZzManager.class);
        }

        return platformManager;
    }

    public PlatformManager getPlatformRecord(String json, Type clazz) {
        SuperManager superManager = JSON.parseObject(json,  clazz);
        PlatformManager platformManager = superManager.managerToPlatformConvert(superManager);
        PlatformManagerData platformManagerData;
        if (!StringUtils.isEmpty( platformManager.getId())) {
            Long platId = platformManager.getId();
            platformManagerData = platformManagerDataRepository.findByPmId(platId);
            if (platformManagerData != null) {
                platformManagerDataRepository.delete(platformManagerData);
            }
            if (platformManager.getMenuType().equals("fj")) {
                List<Prescription> prescriptions = prescriptionRepository.findByMenuId(platId);
                prescriptions.forEach(e->prescriptionRepository.delete(e));
            }
        }
        platformManagerData = superManager.managerToPlatformConvertData(superManager);
        platformManager = platformManagerRepository.save(platformManager);
        if (platformManager.getIsMenu().equals(0)) {
            final Long platId = platformManager.getId();
            platformManagerData.setPmId(platId);
            platformManagerDataRepository.save(platformManagerData);
            if (platformManager.getMenuType().equals("fj")) {
               FjManager fjManager = (FjManager)superManager;
               List<Prescription> prescriptions = fjManager.getCf();
               prescriptions.forEach(e->{
                   e.setMenuId(platId);
                   prescriptionRepository.save(e);
               });
            }
        }
        return platformManager;
    }

    @Override
    public List<Map<String, Object>> findByManager(String type) {
        List<PlatformManager> platformManagers = platformManagerRepository.findByMenuType(type);
        List<Map<String, Object>> maps = new ArrayList<>();
        platformManagers.forEach(e ->maps.add(getManagerMap(e)));
        return maps;
    }

    public Map<String, Object> getManagerMap(PlatformManager e) {
        SuperManager superManager;
        Map<String, Object> map = new HashMap<>();
        if (e.getIsMenu().equals(0)) {
            PlatformManagerData platformManagerData = platformManagerDataRepository.findByPmId(e.getId());
            switch (e.getMenuType()) {
                case "cdm":
                    superManager = new CdmManager();
                    map = JSON.parseObject(
                            JSON.toJSONString(
                                    getManager(
                                            CdmManager.class, superManager, e, platformManagerData
                                    )
                            )
                    );break;
                case "wdm":
                    superManager = new WdmManager();
                    map = JSON.parseObject(
                            JSON.toJSONString(
                                    getManager(
                                            WdmManager.class, superManager, e, platformManagerData
                                    )
                            )
                    );break;
                case "zh":
                    superManager = new ZhManager();
                    map = JSON.parseObject(
                            JSON.toJSONString(
                                    getManager(
                                            ZhManager.class, superManager, e, platformManagerData
                                    )
                            )
                    );break;
                case "sz":
                    superManager = new SzManager();
                    map = JSON.parseObject(
                            JSON.toJSONString(
                                    getManager(
                                            SzManager.class, superManager, e, platformManagerData
                                    )
                            )
                    );break;
                case "yp":
                    superManager = new YpManager();
                    map = JSON.parseObject(
                            JSON.toJSONString(
                                    getManager(
                                            YpManager.class, superManager, e, platformManagerData
                                    )
                            )
                    );break;
                case "zy":
                    superManager = new ZyManager();
                    map = JSON.parseObject(
                            JSON.toJSONString(
                                    getManager(
                                            ZyManager.class, superManager, e, platformManagerData
                                    )
                            )
                    );break;
                case "zzzf":
                    superManager = new ZzzFmManager();
                    map = JSON.parseObject(
                            JSON.toJSONString(
                                    getManager(
                                            ZzzFmManager.class, superManager, e, platformManagerData
                                    )
                            )
                    );break;
                case "mz":
                    superManager = new MzManager();
                    map = JSON.parseObject(
                            JSON.toJSONString(
                                    getManager(
                                            MzManager.class, superManager, e, platformManagerData
                                    )
                            )
                    );break;
                case "gxlx":
                    superManager = new GxlxManager();
                    map = JSON.parseObject(
                            JSON.toJSONString(
                                    getManager(
                                            GxlxManager.class, superManager, e, platformManagerData
                                    )
                            )
                    );break;
                case "fj":
                    superManager = new FjManager();
                    List<Prescription> prescriptions = prescriptionRepository.findByMenuId(e.getId());
                    map = JSON.parseObject(
                            JSON.toJSONString(
                                    getFjManager(
                                            FjManager.class, superManager, e, platformManagerData, prescriptions
                                    )
                            )
                    );break;
                case "fjzz":
                    superManager = new FjzzManager();
                    map = JSON.parseObject(
                            JSON.toJSONString(
                                    getManager(
                                            FjzzManager.class, superManager, e, platformManagerData
                                    )
                            )
                    );break;
                case "zz":
                    superManager = new ZzManager();
                    map = JSON.parseObject(
                            JSON.toJSONString(
                                    getManager(
                                            ZzManager.class, superManager, e, platformManagerData
                                    )
                            )
                    );break;
            }
        } else {
            map = JSON.parseObject(JSON.toJSONString(e));
        }
        return map;
    }
    public <T> T getManager(Class<T> type, SuperManager superManager, PlatformManager e, PlatformManagerData platformManagerData) {
        return  cast(type, superManager.platformToCdmManagerConvert(e, platformManagerData));
    }

    public <T> T getFjManager(Class<T> type, SuperManager superManager, PlatformManager e, PlatformManagerData platformManagerData, List<Prescription> prescriptions) {
        return cast(type, superManager.platformToCdmManagerConvert(e, platformManagerData, prescriptions));
    }

    public static <T> T cast(Class<T> type, Object bean) {
        return type.cast(bean);
    }
    @Override
    public void deletePlatAndPlatDate(Long id) {
        platformManagerRepository.deleteById(id);
        PlatformManagerData platformManagerData = platformManagerDataRepository.findByPmId(id);
        if (platformManagerData != null) {
            platformManagerDataRepository.delete(platformManagerData);
        }
        List<Prescription> prescriptions = prescriptionRepository.findByMenuId(id);
        if (prescriptions.size() > 0) {
            prescriptions.forEach(e->prescriptionRepository.delete(e));
        }
    }

    @Override
    public List<String> findByZyName() {
        List<PlatformManager> platformManagers =
                platformManagerRepository.findByIsMenuAndMenuType(
                        MenuStatus.NOT_MENU_STATUS, "zy"
                );
        List<String> list = new ArrayList<>();
        if (platformManagers.size() >0 ) {
            platformManagers.forEach(e->list.add(e.getName()));
        }
        return list;
    }
}
