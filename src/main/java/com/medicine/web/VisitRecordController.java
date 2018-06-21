package com.medicine.web;

import com.medicine.domain.from.VisitRecordForm;
import com.medicine.service.VisitRecordService;
import com.medicine.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visitRecord")
@Api(value = "就诊信息", description = "就诊相关接口")
public class VisitRecordController {

    @Autowired
    private VisitRecordService visitRecordService;

    @ApiOperation(value = "添加记录", notes = "需要添加 中医四诊 西医检查 诊断治疗 其他信息")
    @PostMapping("/save")
    public JsonResult save(@RequestBody VisitRecordForm visitRecordForm) {
        return JsonResult.builder().data("成功").build();
    }
}
