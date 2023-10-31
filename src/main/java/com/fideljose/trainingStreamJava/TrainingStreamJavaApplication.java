package com.fideljose.trainingStreamJava;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fideljose.trainingStreamJava.DataDummy.Data;
import com.fideljose.trainingStreamJava.model.Person;

import java.util.stream.Collectors;
import java.util.stream.Stream;

//@SpringBootApplication
public class TrainingStreamJavaApplication {

	public static void main(String[] args) {

//		setYeartoPetsEachPerson(Data.people(), 17).forEach(System.out::println);
		System.out.println(isMatchingText(Data.people(), "person 1"));
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

	
}
