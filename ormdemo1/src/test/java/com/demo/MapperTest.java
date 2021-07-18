package com.demo;

import com.alibaba.fastjson.JSON;
import com.test.entry.Role;
import com.test.mapper.RoleMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Random;

public class MapperTest{
    private RoleMapper roleMapper;

    @Before
    public void init(){
        // 使用弱引用创建SqlSessionFactoryBuilder,保证下次GC时回收该对象。
        WeakReference<SqlSessionFactoryBuilder> builder = new WeakReference<>(new SqlSessionFactoryBuilder());
        String mapxmlPath = "mapper";
        SqlSessionFactory factory = builder.get().build(mapxmlPath);
        // rolemapper是已经被动态代理增强后的类
        // 如果不是接口,生成的返回值是一个动态代理,就无法用rolemapper接收
        roleMapper = factory.getMapper(RoleMapper.class);
    }

    /**
     * 查询（普通 & 有@param注解）
     */
    @Test
    public void test01(){
        Role role1 = roleMapper.getRoleById(1L);
        System.out.println("普通方式："+JSON.toJSONString(role1));

        Role role2 = roleMapper.getRoleByIdAndDeptId(1L, 34L);
        System.out.println("@Param注解："+JSON.toJSONString(role2));
    }

    /**
     * 插入
     */
    @Test
    public void test02(){
        Role role = new Role();
        role.setRoleId(Long.valueOf(new Random().nextInt(100)));
        role.setDeptId(1L);
        role.setRemark("remark");
        role.setRoleName("roleName");
        role.setCreateTime(new Date());
        int result = roleMapper.insert(role);
        System.out.println(result >= 1 ? "插入成功" : "插入失败");
    }

    /**
     * 修改
     */
    @Test
    public void test03(){
        int result = roleMapper.updateRoleName(10L, "update remark");
        System.out.println(result >= 1 ? "修改成功" : "修改失败");
    }

    /**
     * 删除
     */
    @Test
    public void test04(){
        int result = roleMapper.deleteById(10L);
        System.out.println(result >= 1 ? "删除成功" : "删除失败");
    }

    /**
     * 通过注解方式实现@Select
     */
    @Test
    public void test05(){
        Role role = roleMapper.selectRoleById(1L);
        System.out.println(JSON.toJSONString(role));
    }

}


