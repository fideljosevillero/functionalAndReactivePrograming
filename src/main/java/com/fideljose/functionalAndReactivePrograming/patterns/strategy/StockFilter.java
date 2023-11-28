package com.fideljose.functionalAndReactivePrograming.patterns.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StockFilter {

    public static List<Stock> getListStockBySymbol(List<Stock> list, String symbol){
        List<Stock> listFiltered = new ArrayList<Stock>();
        return list.stream()
                .filter(e -> e.getSymbol().equalsIgnoreCase(symbol))
                .collect(Collectors.toList());
    }
}
