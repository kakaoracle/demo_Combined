package com.kaka;

import com.kaka.entity.Course;
import com.kaka.mapper.CourseMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ShadingsphereApplicationTests {

    @Resource
    private CourseMapper courseMapper;

    // 已存在两张表course_1与course_2,course_1中插入一条数据
    // 查询语句只要查course表(逻辑名,中间件会自动拼接)就能查出来
    @Test
    void queryAllCourses() {
        List<Course> courses = courseMapper.queryAllCourse();
        System.out.println(courses);
    }

}
