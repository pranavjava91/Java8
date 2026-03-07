package java8;

import java.util.Arrays;
import java.util.List;

public class PalindromeStrings {
	
	public static void main(String[] args) {
		List<String> palindromeNames = Arrays.asList("Telugu", "Tamil", "Malayalam"); 
		
		List<String> findPalindromes = palindromeNames.stream().filter(s->{
			return s.toLowerCase().contentEquals(new StringBuilder(s.toLowerCase()).reverse());
		}).toList();
		
		System.out.println(findPalindromes);
	}

}
