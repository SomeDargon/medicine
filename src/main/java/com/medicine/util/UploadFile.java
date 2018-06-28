package com.medicine.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

@Slf4j
@Data
@Component
public class UploadFile {

    @Value("${server.ip}")
    private String serverIp;

    @Value("${web.upload-path}")
    private String filePath;


    public String uploadImg(MultipartFile file ) throws IllegalStateException, IOException {
        if (file != null) {// 判断上传的文件是否为空
            String path , type;// 文件路径
            LocalDate localDate = LocalDate.now();

            String imgUrl = "/img/" + localDate + "/";
            String pathName = filePath + imgUrl;
            if (!new File(pathName).exists()) {
                new File(pathName).mkdirs();
            }
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename().substring(file.getOriginalFilename().indexOf(".") + 0);// 文件原名称
            log.info("上传的文件原名称:" + fileName);
            // 判断文件类型
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            if (type != null) {// 判断文件类型是否为空
                if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase()) || "JPEG".equals(type.toUpperCase())) {
                    // 自定义的文件名称
                    String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
                    // 设置存放图片文件的路径
                    path = pathName + trueFileName;
                    System.out.println("存放图片文件的路径:" + path);
                    // 转存文件到指定的路径
                    file.transferTo(new File(path));
                    log.info("文件成功上传到指定目录下:" + file);
                    return imgUrl+trueFileName;
                } else {
                    log.info("不是我们想要的文件类型,请按要求重新上传");
                }
            } else {
                log.info("文件类型为空");
            }
        } else {
            log.info("没有找到相对应的文件");
        }

        return "";
    }
}
