package com.autentia.mountebank.shop.application;

import com.autentia.mountebank.shop.domain.Course;
import com.autentia.mountebank.shop.domain.FindCoursesFilterProvider;
import com.autentia.mountebank.shop.mother.CourseMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FindCoursesFilterServiceTest {

    private FindCoursesFilterProvider provider;

    private FindCoursesFilterService sut;

    @BeforeEach
    void setUp() {
        this.provider = Mockito.mock(FindCoursesFilterProvider.class);

        this.sut = new FindCoursesFilterService(provider);
    }


    @Test
    void givenPageAndLimitWhenFindCoursesThenListOfCourse() {
        // arrange
        Integer page = Integer.valueOf(0);
        Integer limit = Integer.valueOf(50);
        Course course = CourseMother.random();
        List<Course> courses = List.of(course);
        Mockito.when(provider.findCourses(page, limit)).thenReturn(courses);

        // act
        List<Course> result = this.sut.findCourses(page, limit);

        // assert
        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(courses.size());
        Mockito.verify(provider).findCourses(page, limit);
    }

}