package com.fideljose.functionalAndReactivePrograming.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private String address;
    private List<Pet> pets;
}
