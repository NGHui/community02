package com.hui.community.mapper;

import com.hui.community.model.User;
import org.apache.ibatis.annotations.*;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/10/8
 */
@Mapper
public interface UserMapper  {

    /**
     * 将github获取到的用户的信息,添加到数据库中
     * @param user
     */
    @Insert("insert into user(account_id,name,token,gmt_create,gmt_modified,avatar_url) values(#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl}) ")
    void insert(User user);

    /**
     * 通过session查询用户
     * @param token
     * @return
     */
    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);

    /**
     * 通过accountId更新用户的信息
     * @param dbUser
     */
    @Update("update user set name = #{name}, token = #{token}, gmt_modified = #{gmtModified},avatar_url = #{avatarUrl} where id = #{id}")
    void update(User dbUser);

    /**
     * accountId 通过accountId 来查询用户
     * @param accountId
     * @return
     */
    @Select("select * from user where account_id = #{accountId}")
    User findByAccountId(@Param(value = "accountId") String accountId);
}
