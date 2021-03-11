package com.dotwww.luckydraw.model;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
public class User implements Serializable {
/*
* 常用的注解 @NotBlank，@NotEmpty，@Pattern，@Email都过期了
* https://stackoverflow.com/questions/48986091/hibernate-notempty-is-deprecated
* 提到，这几个注解直接使用javax.validation.constraints包下的就可以了
* 比如javax.validation.constraints.NotEmpty
* */
    private Integer id;

    /**
     * 用户账号
     */
    @NotBlank(message = "用户账号不能为空")
    @Length(min = 3, max = 20, message = "用户账号最短3位，最长为20位")
    private String username;

    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    @Length(min = 3, max = 20, message = "密码长度为3-20位。")
    private String password;

    /**
     * 用户昵称
     */
    @NotBlank(message = "用户昵称不能为空")
    @Length(min = 3, max = 10, message = "用户昵称最短3位，最长为10位")
    private String nickname;

    /**
     * 邮箱
     */
    @NotEmpty(message = "邮箱不能为空")
    @Email(message = "邮箱地址不符合规则")
    private String email;

    /**
     * 年龄
     */
    @NotEmpty(message = "年龄不能为空")
    @Length(min = 2, max = 2, message = "年龄长度为2位。")
    @Pattern(regexp = "[0-9]*", message = "密码不合法，仅数字")
    private Integer age;

    /**
     * 头像url
     */
    private String head;

    /**
     * 创建时间
     */
    @NotBlank(message = "创建时间不能为空")
    private Date createTime;

    /**
     * 每次抽奖的数量
     */
    private Integer BatchNumber;
}
