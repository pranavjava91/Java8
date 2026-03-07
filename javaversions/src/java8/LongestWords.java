package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LongestWords {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("apple", "banana", "orange", "pineapple", "blueberry");
		int maxLength = words.stream().max((o1,o2)->o1.length()-o2.length()).get().length();
		List<String> result = words.stream().filter(w->w.length() == maxLength).collect(Collectors.toList());
		System.out.println(result);
	}

}
