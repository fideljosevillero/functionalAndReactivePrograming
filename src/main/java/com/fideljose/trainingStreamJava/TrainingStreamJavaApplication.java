package com.fideljose.trainingStreamJava;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fideljose.trainingStreamJava.DataDummy.Data;
import com.fideljose.trainingStreamJava.model.Person;
import com.fideljose.trainingStreamJava.model.Pet;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//@SpringBootApplication
public class TrainingStreamJavaApplication {

	public static void main(String[] args) {

//		setYeartoPetsEachPerson(Data.people(), 17).forEach(System.out::println);
		//System.out.println(isMatchingText(Data.people(), "person 1"));
//		getPetsFromSpecificAge_DistingName(Data.people(), 7);
//		takeMaxPetsYearAndtake10Frist(Data.people(), 7);
//		System.out.println(takeMaxPetsYearAndtake10Frist(Data.people(), 5));
//		System.out.println(getAllPetsFavoriteFood(Data.people()));
//		getListAllPetsFavoriteFood(Data.people()).forEach(System.out::println);
//		getPets(Data.people()).forEach(System.out::println);
		getPartitionPetsName(Data.people()).forEach((k, v) -> System.out.println( k + "--- " + v));

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

}
