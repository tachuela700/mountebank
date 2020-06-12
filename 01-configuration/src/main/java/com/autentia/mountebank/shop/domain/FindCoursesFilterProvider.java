package com.autentia.mountebank.shop.domain;

import java.util.List;

public interface FindCoursesFilterProvider {

    List<Course> findCourses(Integer page, Integer limit);
}
