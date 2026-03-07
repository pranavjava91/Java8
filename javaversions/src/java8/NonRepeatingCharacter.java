package java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class NonRepeatingCharacter {
	public static void main(String[] args) {
		String input = "aabbcdeffg";
		String firstnonDuplicate = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(),
																										LinkedHashMap::new,
																										Collectors.counting()))
																			.entrySet()
																			.stream()
																			.filter(entry->entry.getValue() ==1)
																			.map(Map.Entry::getKey) 
																		    .findFirst() 
																		    .orElse(null);
		 System.out.println("letter is " + firstnonDuplicate);
		
	}

}

// grouping by - groups elements by specified property, collects them into a map

// counting - counts the number of input elements, how many times each character appears

// linkedhashmap - grouping preserves the insertion order

// which is accepting a Function, a Supplier and a Collector as method arguments.
