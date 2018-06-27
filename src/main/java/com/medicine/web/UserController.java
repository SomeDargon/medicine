package com.medicine.web;

import com.medicine.domain.User;
import com.medicine.domain.from.UserForm;
import com.medicine.service.UserService;
import com.medicine.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/apiM/user")
@Api(value = "用户常用接口类", description = "用户登录接口")
public class UserController {

    @Autowired
    private UserService userService;

//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @ApiOperation(value="获取用户", notes="通过session")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public JsonResult<Map> getUser() {
        Map<String, Object> map = new HashMap();
        return JsonResult.<Map<String, Object>>builder().data(map).build();
    }

    @ApiOperation(value="用户登录", notes="通过用户名密码")
    @ApiImplicitParams ({
            @ApiImplicitParam(name = "name", value = "用户名", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String", paramType = "query")
    })
    @PostMapping("/login")
    public JsonResult<Map> login(@RequestBody String name, @RequestBody String password) {
        Map<String, Object> map = new HashMap();
//        password = bCryptPasswordEncoder.encode(password);
        return JsonResult.<Map<String, Object>>builder().data(map).build();
    }

    @GetMapping("/uid")
    @ApiOperation(value = "测试")
    public String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

    @ApiOperation(value="注册用户", notes="填写用户信息")
    @PostMapping("/register")
    public JsonResult register(@RequestBody UserForm userForm) {
        if (userForm.getAccount() == null || userForm.getPassword() == null
                || userForm.getPassword() == null
                ){
            return JsonResult.<String>builder().error("用户名或者密码为空").build();
        }
//        // 密码加密 用户名+密码
//        userForm.setPassword(bCryptPasswordEncoder.
//                encode(userForm.getPassword()+userForm.getUserName()));

        return JsonResult.<User>builder().data(
                userService.save(UserForm.userFormConverterUser(userForm))
        ).build();
    }
}
