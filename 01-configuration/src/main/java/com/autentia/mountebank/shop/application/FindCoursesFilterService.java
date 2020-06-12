package com.autentia.mountebank.shop.application;

import com.autentia.mountebank.shop.domain.Course;
import com.autentia.mountebank.shop.domain.FindCoursesFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindCoursesFilterService {

    private final FindCoursesFilterProvider provider;

    @Autowired
    public FindCoursesFilterService(FindCoursesFilterProvider provider) {
        this.provider = provider;
    }

    public List<Course> findCourses(Integer page, Integer limit) {
        return provider.findCourses(page, limit);
    }
}
