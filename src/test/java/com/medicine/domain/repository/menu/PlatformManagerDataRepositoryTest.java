package com.medicine.domain.repository.menu;

import com.medicine.domain.menu.PlatformManager;
import com.medicine.domain.menu.PlatformManagerData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class PlatformManagerDataRepositoryTest {

    @Autowired
    private PlatformManagerDataRepository platformManagerDataRepository;

    @Autowired
    private PlatformManagerRepository platformManagerRepository;

    public void test() {
        PlatformManager platformManager = new PlatformManager();
        platformManager.setType(1);
        platformManager.setFClass(0L);
        platformManager.setIsMenu(0);
        platformManager = platformManagerRepository.save(platformManager);
        PlatformManagerData data = new PlatformManagerData();
        data.setX1("name");
        data.setPmId(platformManager.getId());
        platformManagerDataRepository.save(data);
    }

    @Test
    public void find() {
        List<PlatformManager> platformManagers = platformManagerRepository.findAll();
        platformManagers.forEach(e->{
            PlatformManagerData data = platformManagerDataRepository.getOne(e.getId());

        });

    }

}