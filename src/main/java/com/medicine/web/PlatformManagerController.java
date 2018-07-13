package com.medicine.web;


import com.alibaba.fastjson.JSON;
import com.medicine.domain.Dictionary;
import com.medicine.domain.dto.PatientDTO;
import com.medicine.domain.dto.PatientRecodDTO;
import com.medicine.domain.dto.YiAnReCodDTO;
import com.medicine.domain.dtoAndFrom.menu.CdmManager;
import com.medicine.domain.dtoAndFrom.menu.SuperManager;
import com.medicine.domain.menu.ComponentManager;
import com.medicine.domain.menu.PlatformManager;
import com.medicine.domain.menu.PlatformManagerData;
import com.medicine.service.ComponentManagerService;
import com.medicine.service.DictionaryService;
import com.medicine.service.PlatformManagerService;
import com.medicine.service.VisitRecordService;
import com.medicine.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "平台管理接口", description = "平台管理"
)
@RequestMapping(value = "/apiM/platform")
public class PlatformManagerController {

    @Autowired
    PlatformManagerService platformManagerService;
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private ComponentManagerService componentManagerService;
    @Autowired
    private VisitRecordService visitRecordService;

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

    @ApiOperation(value = "查询中医数据", notes = "方剂管理使用")
    @GetMapping(value = "/getZyName")
    public List<String> getZyName() {
        return platformManagerService.findByZyName();
    }

    /** 字典平台管理 **/
    @ApiOperation(value = "字典平台 查询")
    @GetMapping(value = "/findDictionary")
    @ApiImplicitParam(name = "sysType", value = "类型")
    public List<Dictionary> findDictionary(@RequestParam String sysType) {
        return dictionaryService.findBySysType(sysType);
    }

    @ApiOperation(value = "字典平台 删除")
    @DeleteMapping(value = "/deleteDictionary")
    public JsonResult<String> deleteDictionary(@RequestParam Long id) {
        dictionaryService.delete(id);
        return JsonResult.builder().data("删除成功").build();
    }

    @ApiOperation(value = "字典平台 添加")
    @PostMapping(value = "/addDictionary")
    public JsonResult<Dictionary> addDictionary(@RequestBody Dictionary dictionary) {
        return JsonResult.builder().data(dictionaryService.save(dictionary)).build();
    }

    /** 成分平台管理 **/
    @ApiOperation(value = "分页查询", notes = "成分平台 根据name查询")
    @GetMapping(value = "/findComponentManagerSByName")
    public List<ComponentManager> findComponentManagerSByName(
            @RequestParam(required = false) String name) {
        return  componentManagerService.findByName(name);
    }

    @ApiOperation(value = "成分平台 删除")
    @DeleteMapping(value = "/deleteById")
    public JsonResult<String> deleteComponentManagerSById(@RequestParam Long id) {
        componentManagerService.delete(id);
        return JsonResult.builder().data("删除成功").build();
    }

    @ApiOperation(value = "成分平台 添加修改")
    @PostMapping(value = "/saveComponentManagerS")
    public JsonResult<ComponentManager> saveComponentManagerS(@RequestBody ComponentManager componentManager) {
        return JsonResult.builder().data(componentManagerService.save(componentManager)).build();
    }

    /** 医案管理 **/
    @ApiOperation(value = "查询患者详情记录")
    @GetMapping("/info")
    public Page<YiAnReCodDTO> findPatiendAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Date visitDate,
            @RequestParam(required = false, defaultValue = "1") Integer size,
            @RequestParam(required = false, defaultValue = "10") Integer page
    ) {
        PageRequest pageRequest = PageRequest.of(size-1, page);
        return visitRecordService.findByNameAndVisitDate(pageRequest, name, visitDate);
    }

}
