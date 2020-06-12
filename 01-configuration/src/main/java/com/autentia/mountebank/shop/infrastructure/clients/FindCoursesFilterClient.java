package com.autentia.mountebank.shop.infrastructure.clients;


import com.autentia.mountebank.shop.infrastructure.clients.dto.CourseFilterResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "courses-client", url = "${feign.client.config.courses-client.url}")
public interface FindCoursesFilterClient {

    @GetMapping(value= "/courses", consumes = "application/json")
    List<CourseFilterResponse> findCourses(@RequestParam(name = "page", required = true) Integer page, @RequestParam(name = "limit", required = true) Integer limit);
}
