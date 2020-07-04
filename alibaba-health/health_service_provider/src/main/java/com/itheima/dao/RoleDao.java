package com.itheima.dao;

import com.itheima.pojo.Role;

import java.util.Set;

public interface RoleDao {
    /**
     * 根据用户id查询该用户所拥有的角色
     * @param userId
     * @return
     */
    Set<Role> findByUserId(Integer userId);
}
