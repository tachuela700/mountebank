package com.autentia.mountebank.shop.infrastructure.rest.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class CourseResponse {
    private UUID id;
    private String name;
    private String level;
}
