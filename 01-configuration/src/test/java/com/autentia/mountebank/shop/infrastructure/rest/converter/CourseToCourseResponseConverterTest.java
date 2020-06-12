package com.autentia.mountebank.shop.infrastructure.rest.converter;

import com.autentia.mountebank.shop.domain.Course;
import com.autentia.mountebank.shop.infrastructure.rest.dto.CourseResponse;
import com.autentia.mountebank.shop.mother.CourseMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CourseToCourseResponseConverterTest {

    private CourseToCourseResponseConverter sut;

    @BeforeEach
    void setUp() {
        this.sut = new CourseToCourseResponseConverter();
    }

    @Test
    void givenCourseWhenConvertThenCourseResponse() {
        // arrange
        Course source = CourseMother.random();

        // act
        CourseResponse result = this.sut.convert(source);

        // assert
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(source.getId());
        assertThat(result.getName()).isEqualTo(source.getName());
        assertThat(result.getLevel()).isEqualTo(source.getLevel());
    }
}