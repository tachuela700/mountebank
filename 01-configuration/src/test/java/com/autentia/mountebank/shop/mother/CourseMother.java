package com.autentia.mountebank.shop.mother;

import com.autentia.mountebank.shop.domain.Course;
import com.github.javafaker.Faker;

import java.util.Locale;

public class CourseMother {

    private static Faker faker = new Faker(new Locale("es", "ES"));

    public static Course random() {
        return Course.builder()
                .id(UUIDMother.random())
                .name(faker.regexify("[a-z1-9]{80}"))
                .level(faker.regexify("[a-z1-9]{10}"))
                .build();

    }
}
