package org.avg.vowels;

import org.avg.vowels.utils.FileUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileUtilsTest {

    private final String ONE_WORD_PATH = "src/test/java/resources/one_word.txt";
    private final String TWO_WORDS_PATH = "src/test/java/resources/two_words.txt";
    private final String TWENTY_WORDS_PATH = "src/test/java/resources/twenty_words.txt";
    private final String NON_EXISTING_PATH = "ddd";

    private final String ASSERT_SIZE_MSG = "File should contain expected number of worlds";

    private final FileUtils fileUtils = new FileUtils();

    @Test
    public void readOneWord() throws IOException {
        List<String> words = fileUtils.readWords(ONE_WORD_PATH);
        assertEquals(ASSERT_SIZE_MSG, 1, words.size());
    }

    @Test
    public void readTwoWords() throws IOException {
        List<String> words = fileUtils.readWords(TWO_WORDS_PATH);
        assertEquals(ASSERT_SIZE_MSG, 2, words.size());
    }

    @Test
    public void readTwentyWords() throws IOException {
        List<String> words = fileUtils.readWords(TWENTY_WORDS_PATH);
        assertEquals(ASSERT_SIZE_MSG, 20, words.size());
    }

    @Test(expected = NoSuchFileException.class)
    public void fileNotExist() throws IOException {
        List<String> words = fileUtils.readWords(NON_EXISTING_PATH);
    }

}
