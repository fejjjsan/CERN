package com.exercises.third.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils {
    public static Map<String, List<String>> parseJson(byte[] content) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Map<String, List<String>>> type = new TypeReference<>(){};
        return mapper.readValue(content, type);
    }

    public static byte[] readBytesFromFile(String file) throws IOException {
        return Files.readAllBytes(Path.of(file));
    }
}
