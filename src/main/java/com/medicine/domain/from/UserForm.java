package com.medicine.domain.from;


import com.medicine.domain.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="user对象",description="用户对象user")
public class UserForm {

    @ApiModelProperty(value = "账号", name = "userName", required = true)
    private String userName;

    @ApiModelProperty(value = "密码", name = "password", required = true)
    private String password;

    @ApiModelProperty(value = "用户名", name = "account", required = true)
    private String account;


    public static User userFormConverterUser(UserForm userForm) {
        return new User(userForm.getUserName(),
                userForm.getPassword(), userForm.getAccount());
    }
}
