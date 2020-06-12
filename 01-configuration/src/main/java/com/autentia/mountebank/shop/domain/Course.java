package com.autentia.mountebank.shop.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class Course {
    private UUID id;
    private String name;
    private String level;
}
