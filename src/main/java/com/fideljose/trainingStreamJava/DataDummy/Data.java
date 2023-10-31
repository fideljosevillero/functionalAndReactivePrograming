package com.fideljose.trainingStreamJava.DataDummy;

import com.fideljose.trainingStreamJava.model.Person;
import com.fideljose.trainingStreamJava.model.Pet;

import java.util.List;
import java.util.stream.Stream;

public class Data {

    public static Stream<Person> people() {
        return Stream.of(
                Person.builder()
                        .name("person 1")
                        .address("Address person 1")
                        .pets(List.of(Pet.builder()
                                .name("name pet 1")
                                .favoriteFood("food 1")
                                .year(3)
                                .build()))
                        .build(),
        Person.builder()
                .name("person 2")
                .address("Address person 2")
                .pets(List.of(Pet.builder()
                        .name("name pet 2")
                        .favoriteFood("food 2")
                                .year(7)
                        .build()))
                .build()
        );
    }
}
