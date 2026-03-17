package java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FlatMapJava8 {
	public static void main(String[] args) {
		
		List<List<String>> skills = Arrays.asList(
				Arrays.asList("Java","Spring","spring Boot"),
				Arrays.asList("React","Angular","Java Script"),
				Arrays.asList("MySQL","PostGresql","oracle"));
		
		List<String> allSkills = skills.stream().flatMap(skillList -> skillList.stream()).collect(Collectors.toList());
		
		System.out.println(allSkills);
		
	
						
		
	}

}
