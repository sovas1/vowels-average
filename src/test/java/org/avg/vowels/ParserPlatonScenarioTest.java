package org.avg.vowels;

import org.avg.vowels.model.Vowel;
import org.avg.vowels.model.VowelsInWord;
import org.avg.vowels.parser.Parser;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

// Example:
//
// INPUT
//
// Platon made bamboo boats.
//
// OUTPUT
//
// ({a, o}, 6) -> 2.5
// ({a, o}, 5) -> 2
// ({a, e}, 4) -> 2

public class ParserPlatonScenarioTest {

    private Parser parser = new Parser();

    private List<VowelsInWord> result;
    private List<String> words = Stream
            .of("Platon", "made", "bamboo", "boats")
            .collect(Collectors.toList());

    @Before
    public void parseFourWords(){
        result = parser.wordsToResultStream(words).collect(Collectors.toList());
        assertEquals(3, result.size());
    }

    @Test
    public void assertFirstGroup() {
        VowelsInWord expected = new VowelsInWord();
        expected.setVowels(Stream.of(Vowel.A, Vowel.O).collect(Collectors.toSet()));
        expected.setWordLen(6);
        expected.setAverage(2.5);

        assertGroup(expected, 0);
    }

    @Test
    public void assertSecondGroup() {
        VowelsInWord expected = new VowelsInWord();
        expected.setVowels(Stream.of(Vowel.A, Vowel.O).collect(Collectors.toSet()));
        expected.setWordLen(5);
        expected.setAverage(2.0);

        assertGroup(expected, 1);
    }

    @Test
    public void assertThirdGroup() {
        VowelsInWord expected = new VowelsInWord();
        expected.setVowels(Stream.of(Vowel.A, Vowel.E).collect(Collectors.toSet()));
        expected.setWordLen(4);
        expected.setAverage(2.0);

        assertGroup(expected, 2);
    }


    private void assertGroup(VowelsInWord expected, Integer listIndex) {
        assertNotNull(result);
        assertEquals(expected, result.get(listIndex));
    }

}
