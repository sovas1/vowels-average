package org.avg.volwes.parser;

import org.avg.volwes.model.VowelsInWord;

import java.util.*;
import java.util.stream.Stream;

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

public class Parser {

    public Stream<VowelsInWord> wordsToResultStream(List<String> words) {
        return Stream.empty();
    }

}
