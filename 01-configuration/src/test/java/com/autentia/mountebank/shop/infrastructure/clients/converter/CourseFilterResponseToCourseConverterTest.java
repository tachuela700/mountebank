package com.autentia.mountebank.shop.infrastructure.clients.converter;

import com.autentia.mountebank.shop.domain.Course;
import com.autentia.mountebank.shop.infrastructure.clients.dto.CourseFilterResponse;
import com.autentia.mountebank.shop.mother.CourseFilterResponseMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CourseFilterResponseToCourseConverterTest {

    private CourseFilterResponseToCourseConverter sut;

    @BeforeEach
    void setUp() {
        this.sut = new CourseFilterResponseToCourseConverter();
    }

    @Test
    void givenCourseFilterResponseWhenConvertThenCourse() {
        // arrange
        CourseFilterResponse source = CourseFilterResponseMother.random();

        // act
        Course result = this.sut.convert(source);

        // assert
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(source.getId());
        assertThat(result.getName()).isEqualTo(source.getName());
        assertThat(result.getLevel()).isEqualTo(source.getLevel());
    }
}