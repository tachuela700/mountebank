package com.autentia.mountebank.shop.infrastructure.rest;

import com.autentia.mountebank.shop.application.FindCoursesFilterService;
import com.autentia.mountebank.shop.domain.Course;
import com.autentia.mountebank.shop.infrastructure.rest.dto.CourseResponse;
import com.autentia.mountebank.shop.mother.CourseMother;
import com.autentia.mountebank.shop.mother.CourseResponseMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

class FindCoursesFilterControllerTest {

    private FindCoursesFilterService service;
    private ConversionService conversionService;

    private FindCoursesFilterController sut;

    @BeforeEach
    void setUp() {
        this.service = Mockito.mock(FindCoursesFilterService.class);
        this.conversionService = Mockito.mock(ConversionService.class);

        this.sut = new FindCoursesFilterController(service, conversionService);
    }


    @Test
    void givenPageAndLimitWhenGetCoursesThenListOfCourse() {
        // arrange
        Integer page = Integer.valueOf(0);
        Integer limit = Integer.valueOf(50);
        Course course = CourseMother.random();
        List<Course> courses = List.of(course);
        Mockito.when(service.findCourses(page, limit)).thenReturn(courses);
        CourseResponse courseResponse = CourseResponseMother.random();
        Mockito.when(conversionService.convert(course, CourseResponse.class)).thenReturn(courseResponse);

        // act
        ResponseEntity<List<CourseResponse>> result = this.sut.getCourses(page, limit);

        // assert
        assertThat(result).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getBody().size()).isEqualTo(courses.size());
        assertThat(result.getBody().get(0).getId()).isEqualTo(courseResponse.getId());
        assertThat(result.getBody().get(0).getName()).isEqualTo(courseResponse.getName());
        assertThat(result.getBody().get(0).getLevel()).isEqualTo(courseResponse.getLevel());
        Mockito.verify(service).findCourses(page, limit);
        Mockito.verify(conversionService, Mockito.atLeastOnce()).convert(course, CourseResponse.class);
    }

    @Test
    void givenPageAndLimitWithoutCoursesWhenGetCoursesThenListOfCourse() {
        // arrange
        Integer page = Integer.valueOf(0);
        Integer limit = Integer.valueOf(50);
        Mockito.when(service.findCourses(page, limit)).thenReturn(List.of());

        // act
        ResponseEntity<List<CourseResponse>> result = this.sut.getCourses(page, limit);

        // assert
        assertThat(result).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getBody().size()).isEqualTo(0);
        Mockito.verify(service).findCourses(page, limit);
        Mockito.verify(conversionService, Mockito.never()).convert(any(Course.class), eq(CourseResponse.class));
    }
}