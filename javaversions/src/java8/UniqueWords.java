package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueWords {
	public static void main(String[] args) {
		  List<String> sentences = List.of("java is cool", "cool code in java"); 
		  
		  
		  Set<String> result = sentences.stream().flatMap(s->Arrays.stream(s.split(" "))).collect(Collectors.toSet());
		  
		  System.out.println(result);


	}

}
