package com.fideljose.functionalAndReactivePrograming.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    private String name;
    private String favoriteFood;
    private int year;
}
