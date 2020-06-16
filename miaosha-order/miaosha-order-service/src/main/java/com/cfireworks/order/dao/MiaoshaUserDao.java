package com.cfireworks.order.dao;

import com.cfireworks.order.entity.MiaoshaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MiaoshaUserDao {
    @Select("select * from miaosha_user where id = #{id}")
    public MiaoshaUser getById(long id);

    @Update("update miaosha_user set password = #{password} where id = #{id}")
    public void update(MiaoshaUser toBeUpdate);
}
