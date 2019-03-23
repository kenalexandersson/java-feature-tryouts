package org.kense.switchexpressions;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

final class CrewIdGenerator {

    static List<String> generate(int rangeStart, int rangeEnd) {

        return IntStream.rangeClosed(rangeStart, rangeEnd)
                .boxed()
                .map(value -> padWithZero(value, rangeEnd))
                .collect(Collectors.toList());
    }

    private static String padWithZero(Integer value, Integer highestNumber) {

        int lengthOfHighestNumber = highestNumber.toString().length();
        int lengthOfCurrentValue = value.toString().length();

        int padSize = lengthOfHighestNumber - lengthOfCurrentValue;

        return switch (padSize){
            case 1 -> String.format("0%d", value);
            case 2 -> String.format("00%d", value);
            case 3 -> String.format("000%d", value);
            case 4 -> String.format("0000%d", value);
            default -> value.toString();
        };
    }

    private CrewIdGenerator() {
    }
}
