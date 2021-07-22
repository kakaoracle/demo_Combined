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

    // 测试插入数据,插入十条,看能否均匀落在两张表中(如果分库就会均匀落在各库各表中)
    // 结果是两张表各自插入5条,course_1中都是奇数,course_2中都是偶数,见img01.png图片
    @Test
    void insertCourses() {
        for (int i=0;i<10;i++) {
            Course c = new Course();
            c.setCname("java");
            c.setUser_id(1001L);
            c.setCstatus("1");
            courseMapper.insert(c);
        }
    }

}






















