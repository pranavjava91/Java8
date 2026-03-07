package java8;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SumofDigits {
	public static void main(String[] args) {
		
		int i = 15623;
		Integer result = Arrays.stream(String.valueOf(i).split(""))
				.collect(Collectors.summingInt(Integer::parseInt));
		
		System.out.println(result);

	}

}
