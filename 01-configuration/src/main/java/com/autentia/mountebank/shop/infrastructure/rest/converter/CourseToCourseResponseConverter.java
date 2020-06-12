package com.autentia.mountebank.shop.infrastructure.rest.converter;

import com.autentia.mountebank.shop.domain.Course;
import com.autentia.mountebank.shop.infrastructure.rest.dto.CourseResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CourseToCourseResponseConverter implements Converter<Course, CourseResponse> {

    @Override
    public CourseResponse convert(Course source) {
        return CourseResponse.builder()
                .id(source.getId())
                .name(source.getName())
                .level(source.getLevel())
                .build();
    }
}
