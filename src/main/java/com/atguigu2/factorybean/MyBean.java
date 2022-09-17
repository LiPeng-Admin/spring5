package com.atguigu2.factorybean;

import com.atguigu2.collectiontype.Course;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/17 10:52
 */
public class MyBean implements FactoryBean<Course> {
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCname("java");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
