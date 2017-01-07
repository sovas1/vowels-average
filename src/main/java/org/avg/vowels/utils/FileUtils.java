package org.avg.vowels.utils;

import org.avg.vowels.model.VowelsInWord;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {

    public List<String> readWords(final String path) throws IOException {
        return Files.lines(Paths.get(path))
                .map(line -> line.split("[^a-zA-Z0-9\\-']"))
                .flatMap(Arrays::stream)
//                .filter(w -> w.matches("^[a-zA-Z0-9\\-']{1,}$"))
                .collect(Collectors.toList());
    }

    public void write(Stream<VowelsInWord> vowelsInWorldStream) {

    }

}
