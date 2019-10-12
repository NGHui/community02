package com.hui.community.mapper;

import com.hui.community.model.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/10/9
 */
@Mapper
public interface QuestionMapper {

    /**
     *
     * @param question 添加提问代码
     */
    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);


    //不分页
    //@Select("select * from question")
    //List<Question> list();

    /**
     *
     * @param offset
     * @param size
     * @return 分页查询
     */
    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    /**
     * 查询问题的数量
     * @return
     */
    @Select("select count(1) from question")
    Integer count();

    /**
     *
     * @param userId 用户id--->作者
     * @param offset
     * @param size
     * @return 查询我的所有问题的列表
     */
    @Select("select * from question where creator = #{userId} limit #{offset},#{size}")
    List<Question> listByUserId(@Param("userId") Integer userId, @Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    /**
     *
     * @param userId
     * @return 查询我的问题的数量
     */
    @Select("select count(1) from question where creator = #{userId}")
    Integer countByUserId(@Param("userId") Integer userId);

    /**
     *
     * @param id
     * @return 通过id查询这个问题
     */
    @Select("select * from question where id = #{id}")
    Question getById(@Param("id") Integer id);

    /**
     * 通过id更新问题列表
     * @param question
     */
    @Update("update question set title = #{title}, description = #{description}, gmt_modified = #{gmtModified}, tag = #{tag} where id = #{id}")
    void update(Question question);
}
