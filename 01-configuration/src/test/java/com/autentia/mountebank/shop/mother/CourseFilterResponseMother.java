package com.autentia.mountebank.shop.mother;

import com.autentia.mountebank.shop.infrastructure.clients.dto.CourseFilterResponse;
import com.github.javafaker.Faker;

import java.util.Locale;

public class CourseFilterResponseMother {

    private static Faker faker = new Faker(new Locale("es", "ES"));

    public static CourseFilterResponse random() {
        return CourseFilterResponse.builder()
                .id(UUIDMother.random())
                .name(faker.regexify("[a-z1-9]{80}"))
                .level(faker.regexify("[a-z1-9]{10}"))
                .build();

    }
}
