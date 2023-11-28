package com.fideljose.functionalAndReactivePrograming.DataDummy;

import com.fideljose.functionalAndReactivePrograming.model.Person;
import com.fideljose.functionalAndReactivePrograming.model.Pet;

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
                                .year(32)
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
                        .build(),
                Person.builder()
                        .name("person 3")
                        .address("Address person 3")
                        .pets(List.of(Pet.builder()
                                .name("name pet 3")
                                .favoriteFood("food 3")
                                .year(9)
                                .build()))
                        .build(),
                Person.builder()
                        .name("person 4")
                        .address("Address person 4")
                        .pets(List.of(Pet.builder()
                                .name("name pet 4")
                                .favoriteFood("food 4")
                                .year(7)
                                .build()))
                        .build(),
                Person.builder()
                        .name("repetido 1")
                        .address("Address person 4")
                        .pets(List.of(Pet.builder()
                                .name("pet name repetido")
                                .favoriteFood("food 4")
                                .year(7)
                                .build()))
                        .build(),
                Person.builder()
                        .name("Repetido 2")
                        .address("Address person 4")
                        .pets(List.of(Pet.builder()
                                .name("pet name repetido")
                                .favoriteFood("food 4")
                                .year(7)
                                .build()))
                        .build(),
                Person.builder()
                        .name("repetido 3")
                        .address("Address person 4")
                        .pets(List.of(Pet.builder()
                                .name("pet name repetido")
                                .favoriteFood("food 4")
                                .year(7)
                                .build()))
                        .build(),
                Person.builder()
                        .name("person 5")
                        .address("Address person 5")
                        .pets(List.of(Pet.builder()
                                .name("name pet 5")
                                .favoriteFood("food 5")
                                .year(2)
                                .build()))
                        .build(),
                Person.builder()
                        .name("person 6")
                        .address("Address person 6")
                        .pets(List.of(Pet.builder()
                                .name("name pet 6")
                                .favoriteFood("food 6")
                                .year(2)
                                .build()))
                        .build(),
                Person.builder()
                        .name("person 7")
                        .address("Address person 7")
                        .pets(List.of(Pet.builder()
                                .name("name pet 7")
                                .favoriteFood("food 7")
                                .year(1)
                                .build()))
                        .build()
                        );
    }
}
