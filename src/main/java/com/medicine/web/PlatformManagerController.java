package com.medicine.web;


import com.alibaba.fastjson.JSON;
import com.medicine.domain.dtoAndFrom.menu.CdmManager;
import com.medicine.domain.dtoAndFrom.menu.SuperManager;
import com.medicine.domain.menu.PlatformManager;
import com.medicine.domain.menu.PlatformManagerData;
import com.medicine.service.PlatformManagerService;
import com.medicine.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Api(value = "管理接口", description = "管理的增删改插")
@RequestMapping(value = "/apiM/platform")
public class PlatformManagerController {

    @Autowired
    PlatformManagerService platformManagerService;

    @ApiOperation(value = "保存管理", notes = "中医疾病管理 cdm  西医疾病管理  wdm 证候管理      zh\n" +
            "舌诊管理    sz    饮片管理     yp  中药管理      zy\n" +
            "治则治法管理 zzzf  脉诊管理     mz  功能类型管理  gxlx\n" +
            "方剂管理    fj    方剂主治管理  fjzz 症状管理     zz\n" +
            "成分管理    cf")
    @PostMapping(value = "/save")
    public JsonResult<Long> save(
            @RequestBody Map<String, Object> data
            ) {
        return JsonResult.builder().data(
                platformManagerService.save(data).getId()
        ).build();
    }

    @ApiOperation(value = "查询管理", notes = "和添加一样")
    @GetMapping(value = "/getListData")
    public List<Map<String, Object>> findByManager(@RequestParam String type) {
        return platformManagerService.findByManager(type);
    }

    @ApiOperation(value = "删除数据", notes = "传入id")
    @DeleteMapping(value = "/delete")
    public JsonResult<Long> deleteById(@RequestParam Long id) {
        platformManagerService.deletePlatAndPlatDate(id);
        return JsonResult.builder().data("删除成功").build();
    }
}
