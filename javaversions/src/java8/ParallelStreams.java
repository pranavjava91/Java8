package java8;

import java.util.Arrays;
import java.util.List;

public class ParallelStreams {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4);
		
		numbers.stream().forEach(i->{
			System.out.println(i + "" + Thread.currentThread().getName());
		});
		
		System.out.println("==========================================================");
		
		numbers.parallelStream().forEach(i -> {
			System.out.println(i + "" + Thread.currentThread().getName());
		});
	} 

}
