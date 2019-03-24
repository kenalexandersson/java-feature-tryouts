package org.kense.java12.switchexpressions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MoodifierTest {

    @Test
    @DisplayName("should generate proper emojis \uD83D\uDE03")
    void shouldGenerateProperEmojis() {

        List<Mood> moods = Arrays.asList(Mood.HAPPY, Mood.ANGRY, Mood.ANNOYED, Mood.SAD, Mood.JOYFUL, Mood.DUNNO);

        List<String> smileys = Moodifier.emojify(moods);

        assertThat(smileys)
                .hasSize(6)
                .containsExactly(Moodifier.EMOJI_HAPPY, Moodifier.EMOJI_ANGRY, Moodifier.EMOJI_ANNOYED, Moodifier.EMOJI_SAD, Moodifier.EMOJI_HAPPY, Moodifier.EMOJI_PILE_OF_SHIT);

        smileys
                .forEach(System.out::println);

    }
}