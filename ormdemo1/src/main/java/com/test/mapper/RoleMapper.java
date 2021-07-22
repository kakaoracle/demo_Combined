package com.test.mapper;

import com.test.entry.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface RoleMapper {
     Role getRoleById(Long id);

     Role getRoleByIdAndDeptId(Long id, @Param("deptId") Long deptId);

     int deleteById(Long id);

     int insert(@Param("role") Role role);

     int updateRoleName(@Param("roleId") Long roleId, @Param("roleName") String name);

    @Select("select * from sys_role where role_id = #{id}")
     Role selectRoleById(Long id);
}
