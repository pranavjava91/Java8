package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ThirdHighest {
	 public static void main(String[] args) { 
		 List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 
				 14, 56, 87);
		 Integer result = listOfIntegers.stream().sorted(Comparator.reverseOrder()).skip(2).findFirst().orElse(-1);
		 System.out.println(result);
	 }


}
