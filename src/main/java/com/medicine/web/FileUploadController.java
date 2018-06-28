package com.medicine.web;

import com.medicine.util.JsonResult;
import com.medicine.util.UploadFile;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/apiM/upload")
public class FileUploadController {

    @Autowired
    private UploadFile uploadFile;

    @ApiOperation(value = "上传图片", notes = "需要file，和用户id，图片分类，返回的是地址")
    @RequestMapping(value = "/uploadImg",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult uploadImg(@RequestParam("file") MultipartFile file
                             ) throws IllegalStateException, IOException {
        return JsonResult.builder().data(uploadFile.uploadImg(file)).build();
    }



}
