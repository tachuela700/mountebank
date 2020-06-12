package com.autentia.mountebank.shop.infrastructure.clients.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@JsonDeserialize(builder = CourseFilterResponse.CourseFilterResponseBuilder.class)
public class CourseFilterResponse {
    private UUID id;
    private String name;
    private String level;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class CourseFilterResponseBuilder {
    }
}
