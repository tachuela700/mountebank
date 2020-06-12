package com.autentia.mountebank.shop.infrastructure.clients;

import com.autentia.mountebank.shop.domain.Course;
import com.autentia.mountebank.shop.domain.FindCoursesFilterProvider;
import com.autentia.mountebank.shop.infrastructure.clients.dto.CourseFilterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindCoursesFilterAdapter implements FindCoursesFilterProvider {

    private final FindCoursesFilterClient client;
    private final ConversionService conversionService;

    @Autowired
    public FindCoursesFilterAdapter(FindCoursesFilterClient client,
                                    ConversionService conversionService) {
        this.client = client;
        this.conversionService = conversionService;
    }

    @Override
    public List<Course> findCourses(Integer page, Integer limit) {
        List<CourseFilterResponse> courses = client.findCourses(page, limit);
        return courses.stream()
                .map(course -> conversionService.convert(course, Course.class))
                .collect(Collectors.toList());
    }
}
