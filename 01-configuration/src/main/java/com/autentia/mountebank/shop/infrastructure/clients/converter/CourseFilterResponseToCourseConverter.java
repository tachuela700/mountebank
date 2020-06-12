package com.autentia.mountebank.shop.infrastructure.clients.converter;

import com.autentia.mountebank.shop.domain.Course;
import com.autentia.mountebank.shop.infrastructure.clients.dto.CourseFilterResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CourseFilterResponseToCourseConverter implements Converter<CourseFilterResponse, Course> {

    @Override
    public Course convert(CourseFilterResponse source) {
        return Course.builder()
                .id(source.getId())
                .name(source.getName())
                .level(source.getLevel())
                .build();
    }
}
