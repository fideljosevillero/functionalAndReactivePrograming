package com.fideljose.functionalAndReactivePrograming;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fideljose.functionalAndReactivePrograming.DataDummy.Data;
import com.fideljose.functionalAndReactivePrograming.model.Person;
import com.fideljose.functionalAndReactivePrograming.model.Pet;
import com.fideljose.functionalAndReactivePrograming.patterns.iterator.MyArrayList;
import com.fideljose.functionalAndReactivePrograming.patterns.strategy.Stock;
import com.fideljose.functionalAndReactivePrograming.patterns.strategy.StockFilter;
import com.sun.source.doctree.SystemPropertyTree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//@SpringBootApplication
public class FunctionalAndReactiveProgramingApplication {

	public static void main(String[] args) {

//		setYeartoPetsEachPerson(Data.people(), 17).forEach(System.out::println);
		//System.out.println(isMatchingText(Data.people(), "person 1"));
//		getPetsFromSpecificAge_DistingName(Data.people(), 7);
//		takeMaxPetsYearAndtake10Frist(Data.people(), 7);
//		System.out.println(takeMaxPetsYearAndtake10Frist(Data.people(), 5));
//		System.out.println(getAllPetsFavoriteFood(Data.people()));
//		getListAllPetsFavoriteFood(Data.people()).forEach(System.out::println);
//		getPets(Data.people()).forEach(System.out::println);
//		getPartitionPetsName(Data.people()).forEach((k, v) -> System.out.println( k + "--- " + v));
//		iteratornPattern();
//		strategyPattern();
//		reduceStreamSumMethod();
//		reduceStreamStringMethod();
		numericStream1();
	}


	static Stream<Person> setYeartoPetsEachPerson(Stream<Person> stream, int newPetsYears){
		return stream.peek(p -> p.getPets()
				.forEach(pet -> {
					pet.setYear(newPetsYears);
				})
		);
	}

	static Boolean isMatchingText(Stream<Person> stream, String text){
		return stream.anyMatch(p -> p.getName().equals(text));
	}

	static Boolean isMatch(Stream<Person> stream, int agePet){
		return stream.map(m -> m.getPets().stream().collect(Collectors.toList()))
				.flatMap(petList -> petList.stream())
						.anyMatch(p -> p.getYear() > agePet || p.getFavoriteFood().contains("food"));
	}

	static void getPetsFromSpecificAge_DistingName(Stream<Person> stream, int age){
		stream.map(p -> p.getPets().stream().collect(Collectors.toList()))
				.flatMap(pets -> pets.stream())
				.filter(p -> p.getYear() == age && p.getName().equalsIgnoreCase("pet name repetido"))
				.distinct()
				.forEach(System.out::print);
	}

	static Pet takeMaxPetsYearAndtake10Frist(Stream<Person> stream, int take){
		return stream
				.limit(take)
				.flatMap(person -> person.getPets().stream())
				.max(Comparator.comparing(pet -> pet.getYear()))
				.get();
				//.orElseThrow(() -> new NoSuchElementException());
	}

	static Stream<String> getListAllPetsFavoriteFood(Stream<Person> stream){
		//stream.map(person -> person.getPets())
		return stream.map(Person::getPets)
				.flatMap(pet -> pet.stream())
				//.map(p -> p.getFavoriteFood())
				.map(Pet::getFavoriteFood);
				//.forEach(System.out::println);
	}

	static List<String> getPets(Stream<Person> stream){
		return stream.flatMap(p -> p.getPets().stream())
				.map(pet -> pet.toString())
				.collect(Collectors.toUnmodifiableList());
	}

	static Map<Boolean, List<Pet>> getPartitionPetsName(Stream<Person> stream){
	//static  void getPartitionPetsName(Stream<Person> stream){
		return stream.flatMap(person -> person.getPets().stream())
				.collect(Collectors.partitioningBy(p -> p.getName().length() > 5));
				//.forEach((k, v) -> System.out.println("--- " + k + "--- " + v));
	}

	public static void iteratornPattern(){
		MyArrayList list = new MyArrayList(new Object[] {17, 7, 314, 87, 9, 01, 16});
		list.forEach(System.out::println);
	}

	public static void strategyPattern(){
		List<Stock> stockList = new ArrayList<>();

		stockList.add(new Stock("AAPL", 318.65, 10));
		stockList.add(new Stock("MSFT", 166.86, 45));
		stockList.add(new Stock("Google", 99, 12.5));
		stockList.add(new Stock("AMZ", 1866.74, 45));
		stockList.add(new Stock("GOOGL", 1480.20, 3.5));
		stockList.add(new Stock("AAPL", 318.65, 8));
		stockList.add(new Stock("AMZ", 1866.74, 9));

		StockFilter.getListStockBySymbol(stockList, "AAPL")
				.forEach(System.out::println);
	}

	public static void reduceStreamSumMethod(){
		System.out.println( List.of(1,2,3,3,3,3,3,3)
				.stream()
				.reduce(0, (a, b) -> a+b));
	}

	public static void reduceStreamStringMethod(){
		String reduce = List.of("cuentos", " ", "de", " ", "los", " ", "hermanos", " ", "Grimm")
				.stream()
				.peek(System.out::println)
				.reduce("init: ", (s1, s2) -> s1.concat(s2));
		System.out.println(reduce);
	}

	private static void numericStream1() {
		OptionalDouble petYearAverage = Data.people().map(p -> p.getPets())
				.flatMap(pet -> pet.stream())
				.mapToInt(pe -> pe.getYear())
				.average();
		System.out.println(petYearAverage.orElseGet(() -> 0.0));
	}


}
