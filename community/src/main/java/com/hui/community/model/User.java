package com.hui.community.model;

import lombok.Data;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/10/8
 */
@Data
public class User {

    private Integer id;
    //账户id
    private String accountId;
    //用户的名称
    private String name;
    //用于session域
    private String token;
    //创建的时间
    private Long gmtCreate;
    //修改时间
    private Long gmtModified;
    //头像的地址
    private String avatarUrl;


}
