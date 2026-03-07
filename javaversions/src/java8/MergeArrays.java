package java8;

import java.util.Arrays;
import java.util.stream.Stream;

public class MergeArrays {
	public static void main(String[] args) {
		int[] a = new int[] { 4, 2, 7, 1 };
		int[] b = new int[] { 8, 3, 9, 5 };
		
		int[] c = Stream.concat(Arrays.stream(a).boxed(),Arrays.stream(b).boxed())
								.sorted()
								.mapToInt(i->i)
								.toArray();
		System.out.println(Arrays.toString(c));

	}

}
