package java8;

import java.util.stream.IntStream;

public class MaxProduct {
	public static void main(String[] args) {

		int[] arr = { 1, 4, 9, 6, 2, 7, 8 };
		
		Integer maxProduct = IntStream.range(0, arr.length).map(i->IntStream.range(i+1,arr.length)
										.map(j-> arr[i] * arr[j])
										.max().orElse(0)).max().orElse(0);
		System.out.println(maxProduct);
	}

}
