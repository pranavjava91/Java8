package java8;

import java.util.Arrays;
import java.util.List;

public class LongestCommonPrefix {
	public static void main(String[] args) {

		List<String> letters = Arrays.asList("flower", "flow", "flight");

		String longestCommonPrefix = letters.stream().reduce((s1, s2) -> {
			int minLength = Math.min(s1.length(), s2.length());
			int i = 0;

			while (i < minLength && s1.charAt(i) == s2.charAt(i)) {
				i++;
			}
			return s1.substring(0, i);
		}).orElse("");
		
		System.out.println(longestCommonPrefix);

	}

}

// reduce takes two elements at a time and returns result

// map - new stream of transformed elements, filter - new stream of fitered elements , reduce - a single value
