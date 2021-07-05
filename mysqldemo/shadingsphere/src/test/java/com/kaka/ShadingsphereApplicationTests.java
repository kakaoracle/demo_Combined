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

    @Test
    void queryAllCourses() {
        List<Course> courses = courseMapper.queryAllCourse();
        System.out.println(courses);
    }

}
