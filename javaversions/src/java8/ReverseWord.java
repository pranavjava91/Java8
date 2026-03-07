package java8;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseWord {

	public static void main(String[] args) {
		String str = "Java Concept Of The Day";
		String result = Arrays.stream(str.split(" ")).map(s -> new StringBuilder(s).reverse()).collect(Collectors.joining(" "));
		System.out.println(result);
	}
	
	// joining converts individual elements to a string
	// map transforms the value of the collection
	// filter satisfies the predicate and returns new list based on the condition

}
