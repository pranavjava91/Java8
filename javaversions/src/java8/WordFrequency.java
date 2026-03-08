package java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequency {
	
	public static void main(String[] args) {
		String sentence = "Java is fun and java is powerful";
		
		Map<String,Long> frequenctWords = Arrays.stream(sentence.split(" ")).
										collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(frequenctWords);
	}

}
