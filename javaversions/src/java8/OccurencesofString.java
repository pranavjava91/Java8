package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OccurencesofString {

	public static void main(String[] args) { 
        List<String> words = Arrays.asList("java scala ruby", "java react spring java"); 
        String word = "java";
        long wordCount =  words.stream().flatMap(s->Arrays.stream(s.split(" "))).peek(System.out::println).filter(i->i.equals(word)).count();
		System.out.println(wordCount);

	}

}
