package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LongestWord {

	public static void main(String[] args) {
		List<String> words = Arrays.asList("cat", "elephant", "dog", "giraffe", "zebra");
		Optional<String> result = words.stream().max(Comparator.comparingInt(String::length));
		result.ifPresent(word -> System.out.println("longest word is " + word));

	}

}
