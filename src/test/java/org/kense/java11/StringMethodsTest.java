package org.kense.java11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class StringMethodsTest {

    @Test
    @DisplayName("should be blank")
    void shouldBeBlank() {

        assertThat("".isBlank())
                .isTrue();

        assertThat(" ".isBlank())
                .isTrue();
    }

    @Test
    @DisplayName("should get correct List of lines")
    void shouldGetCorrectListOfLines() throws URISyntaxException, IOException {

        URL fileUrl = getClass().getClassLoader().getResource("message.txt");
        assertThat(fileUrl).isNotNull();

        Path path = Path.of(fileUrl.toURI());

        String fileContent = Files.readString(path);

        List<String> lines = fileContent.lines()
                .collect(Collectors.toList());

        assertThat(lines)
                .contains("A message")
                .hasSize(13);

        System.out.println(lines);
    }

    @Test
    @DisplayName("should strip strings properly")
    void shouldStripStrings() {

        String line = "  * strip(), stripLeading(), stripTrailing()  ";

        assertThat(line.stripLeading())
                .isEqualTo("* strip(), stripLeading(), stripTrailing()  ");

        assertThat(line.stripTrailing())
                .isEqualTo("  * strip(), stripLeading(), stripTrailing()");

        assertThat(line.strip())
                .isEqualTo("* strip(), stripLeading(), stripTrailing()");

        // the strip methods can also handle unicode, which trim() methods does not.

    }

    @Test
    @DisplayName("should repeat string")
    void shouldRepeatString() {
        assertThat("war".repeat(2))
                .isEqualTo("warwar");
    }
}