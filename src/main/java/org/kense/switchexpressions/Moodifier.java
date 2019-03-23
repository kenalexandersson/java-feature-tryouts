package org.kense.switchexpressions;

import java.util.List;
import java.util.stream.Collectors;

final class Moodifier {

    static final String EMOJI_HAPPY = "\uD83D\uDE03";
    static final String EMOJI_SAD = "\uD83D\uDE22";
    static final String EMOJI_ANGRY = "\uD83D\uDE21";
    static final String EMOJI_ANNOYED = "\uD83E\uDD28";
    static final String EMOJI_PILE_OF_SHIT = "\uD83D\uDCA9";

    static List<String> emojify(List<Mood> moods) {

        return moods.stream()
                .map(Moodifier::stateOfMind)
                .collect(Collectors.toList());

    }

    private static String stateOfMind(Mood mood) {
        return switch (mood){
            case HAPPY, GIDDY, JOYFUL -> EMOJI_HAPPY;
            case SAD, SOMBER -> EMOJI_SAD;
            case ANGRY -> EMOJI_ANGRY;
            case ANNOYED -> EMOJI_ANNOYED;
            default -> EMOJI_PILE_OF_SHIT;
        };
    }
}
