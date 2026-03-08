package City;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsOnCityData {
	public static void main(String[] args) {

		List<City> cities = Arrays.asList(new City("Delhi", 12000), new City("Mumbai", 800000),
				new City("Bangalore", 450000), new City("Hyderabad", 1200000), new City("Chennai", 60000));

		// City with the second highest population

		Optional<City> secondHighest = cities.stream().sorted(Comparator.comparingInt(c -> c.population)).skip(1)
				.findFirst();
		System.out.println(secondHighest.get().name);

		// Group by first character of name, then max population in each group

		Map<Character, City> maxByInitial = cities.stream()
				.collect(Collectors.groupingBy(c -> c.getName().charAt(0), Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparingInt(City::getPopulation)), Optional::get)));
		System.out.println(maxByInitial);

		// Average population of top 3 most populated cities.

		Double averagePopulation = cities.stream().sorted(Comparator.comparingInt(City::getPopulation).reversed())
				.limit(3).collect(Collectors.averagingInt(City::getPopulation));
		System.out.println(averagePopulation);

		// Map of population range -> city names

		Map<String, List<String>> byRange = cities.stream().collect(Collectors.groupingBy(c -> {
			int p = c.getPopulation();
			if (p <= 100_000)
				return "0–100k";
			else if (p <= 500_000)
				return "100k–500k";
			else if (p <= 1_000_000)
				return "500k–1M";
			else
				return "1M+";
		}, Collectors.mapping(City::getName, Collectors.toList())));
		System.out.println(byRange);

		// 5. Using reduce: String of cities ordered by population
		// Expected output: Hyderabad(1200000) > Mumbai(800000) > Bangalore(450000) >
		// Chennai(60000) > Delhi(12000)

		String result = cities.stream().sorted(Comparator.comparingInt(City::getPopulation).reversed())
				.map(c -> c.getName() + "(" + c.getPopulation() + ")").reduce((a, b) -> a + " > " + b).orElse("");
		System.out.println(result);

	}

}
