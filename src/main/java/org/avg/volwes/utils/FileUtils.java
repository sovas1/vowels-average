package org.avg.volwes.utils;

import org.avg.volwes.model.VowelsInWord;

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
                .map(line -> line.split("[\\s]+"))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }

    public void write(Stream<VowelsInWord> vowelsInWorldStream) {

    }

}
