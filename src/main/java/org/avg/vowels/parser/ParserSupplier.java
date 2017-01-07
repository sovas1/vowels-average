package org.avg.vowels.parser;

import org.avg.vowels.model.Vowel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class ParserSupplier {

    /**
     * @param wordString
     * @return List of all vowels contained in wordString
     */
    List<Vowel> findVowels(String wordString) {
        wordString = wordString.toLowerCase();
        List<Character> availableVowels = Stream.of(Vowel.values())
                .map(Vowel::getValue)
                .sorted()
                .collect(Collectors.toList());

        List<Character> word = wordString.chars()
                .mapToObj(c -> (char) c)
                .sorted()
                .collect(Collectors.toList());

        List<int[]> indexList = availableVowels.stream()
                .map(e -> IntStream.range(0, word.size())
                        .filter(i -> word.get(i) == e)
                        .toArray())
                .filter(v -> v.length > 0)
                .collect(Collectors.toList());

        List<Integer> allIndexes = new ArrayList<>();
        for (int[] anIndexList : indexList) {
            for (int anAnIndexList : anIndexList) {
                allIndexes.add(anAnIndexList);
            }
        }

        return allIndexes.stream()
                    .map(i -> Vowel.valueOf(String.valueOf(Character.toUpperCase(word.get(i)))))
                .collect(Collectors.toList());
    }
}
