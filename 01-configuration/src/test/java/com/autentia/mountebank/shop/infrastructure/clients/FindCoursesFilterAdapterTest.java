package com.autentia.mountebank.shop.infrastructure.clients;

import com.autentia.mountebank.shop.domain.Course;
import com.autentia.mountebank.shop.infrastructure.clients.dto.CourseFilterResponse;
import com.autentia.mountebank.shop.mother.CourseFilterResponseMother;
import com.autentia.mountebank.shop.mother.CourseMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.convert.ConversionService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

public class FindCoursesFilterAdapterTest {

    private FindCoursesFilterClient client;
    private ConversionService conversionService;

    private FindCoursesFilterAdapter sut;

    @BeforeEach
    void setUp() {
        this.client = Mockito.mock(FindCoursesFilterClient.class);
        this.conversionService = Mockito.mock(ConversionService.class);

        this.sut = new FindCoursesFilterAdapter(client, conversionService);
    }

    @Test
    void givenPageAndLimitWhenFindCoursesThenListOfCourse() {
        // arrange
        Integer page = Integer.valueOf(0);
        Integer limit = Integer.valueOf(50);
        CourseFilterResponse courseFilterResponse = CourseFilterResponseMother.random();
        List<CourseFilterResponse> courseFilterResponses = List.of(courseFilterResponse);
        Mockito.when(client.findCourses(page, limit)).thenReturn(courseFilterResponses);
        Course course = CourseMother.random();
        Mockito.when(conversionService.convert(courseFilterResponse, Course.class)).thenReturn(course);

        // act
        List<Course> result = this.sut.findCourses(page, limit);

        // assert
        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(courseFilterResponses.size());
        assertThat(result.get(0).getId()).isEqualTo(course.getId());
        assertThat(result.get(0).getName()).isEqualTo(course.getName());
        assertThat(result.get(0).getLevel()).isEqualTo(course.getLevel());
        Mockito.verify(client).findCourses(page, limit);
        Mockito.verify(conversionService, Mockito.atLeastOnce()).convert(courseFilterResponse, Course.class);
    }

    @Test
    void givenPageAndLimitWithoutCoursesWhenFindCoursesThenListOfCourse() {
        // arrange
        Integer page = Integer.valueOf(0);
        Integer limit = Integer.valueOf(50);
        Mockito.when(client.findCourses(page, limit)).thenReturn(List.of());

        // act
        List<Course> result = this.sut.findCourses(page, limit);

        // assert
        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(0);
        Mockito.verify(client).findCourses(page, limit);
        Mockito.verify(conversionService, Mockito.never()).convert(any(CourseFilterResponse.class), eq(Course.class));
    }
}