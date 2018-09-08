package com.lee9213.gmall.user.dal.mapper;

import com.lee9213.gmall.user.dal.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lee9213@163.com
 * @version 1.0
 * @date 2018-08-21 11:19
 */
@Mapper
public interface IUserMapper {

    UserEntity getUserByUserName(String userName);

    int insert(UserEntity user);

}
