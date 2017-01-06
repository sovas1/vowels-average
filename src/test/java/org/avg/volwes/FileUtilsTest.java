package org.avg.volwes;

import org.avg.volwes.utils.FileUtils;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FileUtilsTest {

    private final String ONE_WORD_PATH = "resources/one_word.txt";
    private final String NON_EXISTING_PATH = "";

    private final FileUtils fileUtils = new FileUtils();

    @Test
    public void readExistingFile() {
        File file = fileUtils.read(ONE_WORD_PATH);
        assertTrue(file.exists());
    }

    @Test
    public void fileNotExist() {
        File file = fileUtils.read(NON_EXISTING_PATH);
        assertFalse(file.exists());
    }

}
