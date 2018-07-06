package com.medicine.web;


import com.medicine.domain.menu.ComponentManager;
import com.medicine.service.ComponentManagerService;
import com.medicine.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "成分管理", description = "所有操作")
@RestController
@RequestMapping(value = "/apiM/component")
public class ComponentManagerController {

    @Autowired
    private ComponentManagerService componentManagerService;

    @ApiOperation(value = "分页查询", notes = "根据name查询")
    @GetMapping(value = "/findByName")
    public List<ComponentManager> findByName(
            @RequestParam(required = false) String name) {
        return  componentManagerService.findByName(name);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping(value = "/deleteById")
    public JsonResult<String> deleteById(@RequestParam Long id) {
        componentManagerService.delete(id);
        return JsonResult.builder().data("删除成功").build();
    }

    @ApiOperation(value = "添加修改")
    @PostMapping(value = "/save")
    public JsonResult<ComponentManager> save(@RequestBody ComponentManager componentManager) {
        return JsonResult.builder().data(componentManagerService.save(componentManager)).build();
    }
}
