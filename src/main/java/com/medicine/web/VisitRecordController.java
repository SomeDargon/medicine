package com.medicine.web;

import com.medicine.domain.dto.VisitRecordDTO;
import com.medicine.domain.from.VisitRecordForm;
import com.medicine.service.VisitRecordService;
import com.medicine.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/visitRecord")
@Api(value = "就诊信息", description = "就诊相关接口")
public class VisitRecordController {

    @Autowired
    private VisitRecordService visitRecordService;

    @ApiOperation(value = "添加记录", notes = "需要添加 中医四诊 西医检查 诊断治疗 其他信息")
    @PostMapping("/save")
    public JsonResult save(@RequestBody VisitRecordForm visitRecordForm) {
        visitRecordService.save(visitRecordForm);
        return JsonResult.builder().data("成功").build();
    }

    @ApiOperation(value = "查询患者详情记录")
    @GetMapping("/find")
    public VisitRecordDTO getPatiendId(@RequestParam Long id) {
        VisitRecordDTO visitRecordDTO = new VisitRecordDTO();
        visitRecordService.findById(id);
        return visitRecordDTO;
    }


}
