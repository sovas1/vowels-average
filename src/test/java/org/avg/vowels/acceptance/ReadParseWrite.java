package org.avg.vowels.acceptance;

import org.avg.vowels.model.VowelsInWord;
import org.avg.vowels.parser.Parser;
import org.avg.vowels.utils.FileUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

// OUTPUT
//
// ({a, o}, 6) -> 2.5
// ({a, o}, 5) -> 2
// ({a, e}, 4) -> 2

public class ReadParseWrite {

    private FileUtils fileUtils = new FileUtils();
    private Parser parser = new Parser();

    private final String INPUT_PATH = "src/test/java/resources/INPUT.txt";
    private final String OUTPUT_PATH = "src/test/java/resources/OUTPUT.txt";

    @Test
    public void readParseWritePlaton() throws IOException {

        List<String> words = fileUtils.readWords(INPUT_PATH);
        assertEquals(4, words.size());

        List<VowelsInWord> vowelsInWordList = parser.wordsToResultStream(words).collect(Collectors.toList());
        assertEquals(3, vowelsInWordList.size());

        fileUtils.write(vowelsInWordList, OUTPUT_PATH);
    }

}
