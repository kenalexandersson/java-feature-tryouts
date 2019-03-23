package org.kense.switchexpressions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CrewIdGeneratorTest {

    @Test
    @DisplayName("should generate correctly zero-padded crewIds")
    void shouldGenerateCorrectlyPaddedCrewIds() {

        List<String> generateCrewIds = CrewIdGenerator.generate(1, 10000);

        assertThat(generateCrewIds)
                .hasSize(10000)
                .contains("00446", "00448");

        generateCrewIds.forEach(System.out::println);
    }
}