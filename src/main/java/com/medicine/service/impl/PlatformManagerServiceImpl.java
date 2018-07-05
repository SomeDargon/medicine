package com.medicine.service.impl;

import com.alibaba.fastjson.JSON;
import com.medicine.domain.dtoAndFrom.menu.CdmManager;
import com.medicine.domain.dtoAndFrom.menu.SuperManager;
import com.medicine.domain.menu.PlatformManager;
import com.medicine.domain.menu.PlatformManagerData;
import com.medicine.domain.repository.menu.PlatformManagerDataRepository;
import com.medicine.domain.repository.menu.PlatformManagerRepository;
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

    @Override
    public PlatformManager save(Map<String, Object> data) {
        String type = data.get("sysType").toString();
        String json = JSON.toJSONString(data, true);
        PlatformManager platformManager = new PlatformManager();
        switch (type) {
            case "cdm":return getPlatformRecord(json, CdmManager.class);

        }

        return platformManager;
    }

    public PlatformManager getPlatformRecord(String json, Type clazz) {
        SuperManager superManager = JSON.parseObject(json,  clazz);
        PlatformManager platformManager = superManager.managerToPlatformConvert(superManager);
        PlatformManagerData platformManagerData;
        if (!StringUtils.isEmpty(platformManager.getId())) {
            platformManagerData = platformManagerDataRepository.findByPmId(platformManager.getId());
            if (platformManagerData != null) {
                platformManagerDataRepository.delete(platformManagerData);
            }
        }
        platformManagerData = superManager.managerToPlatformConvertData(superManager);
        platformManager = platformManagerRepository.save(platformManager);
        if (platformManager.getIsMenu().equals(0)) {
            platformManagerData.setPmId(platformManager.getId());
            platformManagerDataRepository.save(platformManagerData);
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
                    );
            }
        } else {
            map = JSON.parseObject(JSON.toJSONString(e));
        }
        return map;
    }
    public <T> T getManager(Class<T> type, SuperManager superManager, PlatformManager e, PlatformManagerData platformManagerData) {
        return  cast(type, superManager.platformToCdmManagerConvert(e, platformManagerData));
    }
    public static <T> T cast(Class<T> type, Object bean) {
        return type.cast(bean);
    }
    @Override
    public void deletePlatAndPlatDate(Long id) {
        platformManagerRepository.deleteById(id);
        PlatformManagerData platformManagerData = platformManagerDataRepository.findByPmId(id);
        platformManagerDataRepository.delete(platformManagerData);
    }
}
