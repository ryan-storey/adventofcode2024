package adventofcode2024.day1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import adventofcode2024.utils.IOUtils;

public class day1 {

    private static final String DATA = "adventofcode2024/day1/input.txt";
    private static final String DELIMITER = "   ";
    public static void main(String[] args) {
        List<List<Integer>> input = IOUtils.splitSeparatedList(IOUtils.readFileIntoList(DATA), DELIMITER)
                                            .stream()
                                            .map(e -> e.stream()
                                                        .map(x -> Integer.parseInt(x))
                                                        .sorted()
                                                        .collect(Collectors.toList()))
                                            .collect(Collectors.toList());
        int combined = IntStream.range(0, Math.min(input.get(0).size(), input.get(0).size()))
                            .mapToObj(i-> (Math.abs(input.get(0).get(i) - input.get(1).get(i))))
                            .mapToInt(Integer::intValue)
                            .sum();
        int similarityScore = IntStream.range(0, Math.min(input.get(0).size(), input.get(0).size()))
                            .mapToObj(i-> (input.get(1).stream()
                                                                .filter(e -> e.equals(input.get(0).get(i)))
                                                                .count() * input.get(0).get(i)))
                            .mapToInt(Long::intValue)
                            .sum();
    }
}
