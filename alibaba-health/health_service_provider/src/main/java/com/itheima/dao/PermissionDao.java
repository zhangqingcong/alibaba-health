package com.itheima.dao;

import com.itheima.pojo.Permission;

import java.util.Set;

public interface PermissionDao {
    /**
     * 根据角色id查询该角色所拥有的权限
     * @param roleId
     * @return
     */
   public Set<Permission> findByRoleId(Integer roleId);
}
