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
import java.util.stream.IntStream;
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
//		numericStream1();
//		numericStream2();
//		boundedStreams();
		infiniteIterate();
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
				.mapToInt(Pet::getYear)
				.average();
		System.out.println(petYearAverage.orElseGet(() -> 0.0));
	}

	private static void numericStream2(){
		// sum
		int intStream = IntStream.of(1, 2, 3, 4, 5, 6, 71).sum();
		System.out.println("Sum " + intStream);

		// max
		OptionalInt max = IntStream.of(1, 2, 3, 4, 5, 6, 71).max();
		System.out.println("Max " + max.getAsInt());

		// min
		OptionalInt intStreamMin = IntStream.of(1, 2, 3, 4, 5, 6, 71).min();
		System.out.println("Min " + intStreamMin.getAsInt());

		// average
		OptionalDouble avg = IntStream.of(1, 2, 3, 4, 5, 6, 71).average();
		System.out.println("Average " + avg.getAsDouble());

		// average 2
		double avg2 = IntStream.of().average().orElse(0.0);
		System.out.println("Average " + avg2);

		// summaryStatistics
		IntSummaryStatistics summaryStatistics = IntStream.of(1, 2, 3, 4, 5, 6, 71).summaryStatistics();
		System.out.println("summaryStatistics " + summaryStatistics);
	}

	public static void boundedStreams() {
		List<Integer> list = List.of(1,2,3,4,5,6,7);
		Stream<Integer> stream = list.stream();
		stream.forEach(System.out::println);

		Map<Integer, String> map = Map.of(1, "one", 2, "two", 3, "Three", 4, "four", 5, "five");
		Collection<String> values = map.values();
		System.out.println(values);

		Stream<Integer> keys = map.keySet().stream();
		keys.forEach(System.out::println);

		Stream<Map.Entry<Integer, String>> stream1 = map.entrySet().stream();
		stream1.forEach(System.out::println);

		Stream<String> streamString = Stream.of("Hi!", "I", "am", "back", "...");
		streamString.forEach(System.out::println);

		System.out.println("--- Integer Stream ---");

		Integer[] integerArray = {1,2,6,7,9,34,57,79};
		Stream<Integer> integerStream = Arrays.stream(integerArray);
		integerStream.forEach(System.out::println);

		System.out.println("--- int Stream ---");

		int[] intArray = {1,2,6,7,9,34,57,79};
		IntStream intStream = Arrays.stream(intArray);
		intStream.forEach(System.out::println);

		System.out.println("--- Constructor (build) ----");
		Stream.Builder<Integer> builder = Stream.builder();
		builder.add(6796);
		builder.add(24);
		builder.add(34);
		builder.add(1);
		builder.add(879);
		Stream<Integer> build = builder.build();
		build.forEach(System.out::println);

	}

	public static void infiniteIterate(){
//		Stream.iterate(1, i -> i*2)
//				.limit(100)
//				.forEach(System.out::println);
//
//		Stream.iterate("Hi!", t -> t.concat(" - - - "))
//				.limit(10000)
//				.forEach(System.out::println);

//		Stream.generate(() -> "Hello!")
//				.forEach(System.out::println);
		Stream.generate( () -> new Random().nextDouble() )
				.forEach((value) -> System.out.println(value*100));
	}

}