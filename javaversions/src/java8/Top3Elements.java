package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Top3Elements {
	public static void main(String[] args) {
		List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 
				14, 56, 87); 
		
		List<Integer> result = listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).toList();
		
		System.out.println(result);
	}

}
