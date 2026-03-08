package java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RepeatedNumber {
	public static void main(String[] args) { 
		 
        List<Integer> numbers = Arrays.asList(10, 20, 5, 8, 30, 25, 30);
        
        Integer result = numbers.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
        									.entrySet()
        									.stream()
        									.max(Map.Entry.comparingByValue())
        									.map(Map.Entry::getKey)
        									.orElse(null);
        System.out.println(result);
        
	}

}
