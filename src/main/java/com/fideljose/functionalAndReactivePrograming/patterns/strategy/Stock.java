package com.fideljose.functionalAndReactivePrograming.patterns.strategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Stock {
    private String symbol;
    private double price;
    private double units;
}
