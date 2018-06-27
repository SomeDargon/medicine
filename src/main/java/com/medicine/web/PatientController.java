package com.medicine.web;


import com.medicine.domain.dto.PatientDTO;
import com.medicine.domain.from.PatientFrom;
import com.medicine.service.PatientService;
import com.medicine.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "病人接口", description = "病人操作接口")
@RequestMapping(value = "/apiM/patient")
public class PatientController {

    @Autowired
    private PatientService PatientService;

    @ApiOperation(value = "查询分页", notes = "现在不知道要传什么值，未做条件查询")
    @GetMapping(value = "/list")
    public Page<PatientDTO> findAllPage(
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer size,
            @RequestParam(value = "searchV", required = false) String name
    ) {
        return PatientService.findPatientCriteria(page - 1, size, name);

    }

    @ApiOperation(value = "新增/修改", notes = "输入值还不知道")
    @PostMapping(value = "/add")
    public JsonResult save(@RequestBody PatientFrom PatientFrom) {
        return JsonResult.builder().data(
                PatientService.save(PatientFrom).getId()).build();
    }




}
