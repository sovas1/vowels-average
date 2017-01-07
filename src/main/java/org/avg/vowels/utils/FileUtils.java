package org.avg.vowels.utils;

import org.avg.vowels.model.VowelsInWord;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtils {

    public List<String> readWords(final String path) throws IOException {
        return Files.lines(Paths.get(path))
                .map(line -> line.split("[^a-zA-Z0-9\\-']"))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }

    public void write(List<VowelsInWord> vowelsInWorld, final String path) throws IOException {
        List<String> out = vowelsInWorld.stream()
                .map(VowelsInWord::toString)
                .map(v -> v.replaceAll("\\[", "").replaceAll("\\]", ""))
                .collect(Collectors.toList());
        Files.write(Paths.get(path), out);
    }

}
