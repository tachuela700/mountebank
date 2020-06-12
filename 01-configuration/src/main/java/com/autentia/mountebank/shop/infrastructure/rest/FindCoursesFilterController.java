package com.autentia.mountebank.shop.infrastructure.rest;

import com.autentia.mountebank.shop.application.FindCoursesFilterService;
import com.autentia.mountebank.shop.domain.Course;
import com.autentia.mountebank.shop.infrastructure.rest.dto.CourseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "${autentia.boot.resources.filters.courses}", produces = { MediaType.APPLICATION_JSON_VALUE })
public class FindCoursesFilterController {

    private final FindCoursesFilterService service;
    private final ConversionService conversionService;

    @Autowired
    public FindCoursesFilterController(FindCoursesFilterService service,
                                       ConversionService conversionService) {
        this.service = service;
        this.conversionService = conversionService;
    }

    @GetMapping
    public ResponseEntity<List<CourseResponse>> getCourses(@RequestParam(name = "page", required = true) Integer page, @RequestParam(name = "limit", required = true) Integer limit) {
        List<Course> courses = this.service.findCourses(page, limit);
        List<CourseResponse> courseResponses = courses.stream()
                .map(course -> this.conversionService.convert(course, CourseResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(courseResponses);

    }
}
