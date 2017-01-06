package org.avg.volwes;

import org.avg.volwes.model.Volwe;
import org.avg.volwes.model.VolwesInWord;
import org.avg.volwes.utils.Parser;
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

    private List<VolwesInWord> result;
    private List<String> words;

    @Test
    public void parseFourWords(){
        words = Stream
                .of("Platon", "made", "bamboo", "boats.")
                .collect(Collectors.toList());

        result = parser.wordsToStream(words).collect(Collectors.toList());

        assertEquals(3, result.size());
    }

    @Test
    public void assertFirstGroup() {
        VolwesInWord expected = new VolwesInWord();
        expected.setVolwes(Stream.of(Volwe.A, Volwe.O).collect(Collectors.toSet()));
        expected.setWordLen(6);
        expected.setAverage(2.5);

        assertGroup(expected, 0);
    }

    @Test
    public void assertSecondGroup() {
        VolwesInWord expected = new VolwesInWord();
        expected.setVolwes(Stream.of(Volwe.A, Volwe.O).collect(Collectors.toSet()));
        expected.setWordLen(5);
        expected.setAverage(2.0);

        assertGroup(expected, 1);
    }

    @Test
    public void assertThirdGroup() {
        VolwesInWord expected = new VolwesInWord();
        expected.setVolwes(Stream.of(Volwe.A, Volwe.E).collect(Collectors.toSet()));
        expected.setWordLen(4);
        expected.setAverage(2.0);

        assertGroup(expected, 2);
    }


    private void assertGroup(VolwesInWord expected, Integer listIndex) {
        assertNotNull(result);
        assertEquals(expected, result.get(listIndex));
    }

}
