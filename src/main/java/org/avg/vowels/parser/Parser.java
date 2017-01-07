package org.avg.vowels.parser;

import org.avg.vowels.model.Vowel;
import org.avg.vowels.model.VowelsInWord;

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

    private ParserSupplier supplier = new ParserSupplier();

    public Stream<VowelsInWord> wordsToResultStream(List<String> words) {

        List<VowelsInWord> vowelsInWordList = new ArrayList<>();

        words.stream()
                .forEach(w -> {
                    List<Vowel> allVowels = supplier.findVowels(w);

                    VowelsInWord vowelsInWord = new VowelsInWord();
                    vowelsInWord.setVowels(new HashSet<>(allVowels));
                    vowelsInWord.setWordLen(w.length());
                    vowelsInWord.setAverage((double) allVowels.size());
                    vowelsInWord.incrementTotal();

                    final boolean[] contains = new boolean[1];
                    vowelsInWordList.stream()
                            .filter(v -> v.equals(vowelsInWord))
                            .forEach(v -> {
                                contains[0] = true;
                                v.incrementTotal();
                                v.setAverage((v.getAverage() + vowelsInWord.getAverage()) / v.getTotal());
                            });

                    if(!contains[0]) {
                        vowelsInWordList.add(vowelsInWord);
                    }

                });

        return vowelsInWordList.stream().sorted();
    }

}
