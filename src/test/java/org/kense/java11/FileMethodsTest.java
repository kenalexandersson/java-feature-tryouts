package org.kense.java11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class FileMethodsTest {

    @Test
    @DisplayName("should get file content using readString()")
    void shouldGetFileContentUsingReadString() throws IOException, URISyntaxException {

        URL fileUrl = getClass().getClassLoader().getResource("message.txt");
        assertThat(fileUrl).isNotNull();

        Path path = Path.of(fileUrl.toURI());

        String fileContent = Files.readString(path);

        assertThat(fileContent)
                .isNotEmpty()
                .contains("A message")
                .hasLineCount(13);

        System.out.println(fileContent);
    }

    @Test
    void shouldWriteFileUsingWriteString() throws IOException {

        Path path = Files.writeString(Files.createTempFile("test", ".txt"), "Some content in a file");

        assertThat(Files.readString(path))
                .isNotEmpty()
                .isEqualTo("Some content in a file");
    }
}