package org.avg.volwes.model;

import java.util.HashSet;
import java.util.Set;

public class VowelsInWord {

    private Set<Vowel> vowels;
    private Integer wordLen;
    private Double average;

    public VowelsInWord() {
        vowels = new HashSet<>();
        wordLen = 0;
        average = 0.0;
    }

    public void addVolwe(Vowel vowel) {
        vowels.add(vowel);
    }

    public Set<Vowel> getVowels() {
        return vowels;
    }

    public Integer getWordLen() {
        return wordLen;
    }

    public void setVowels(Set<Vowel> vowels) {
        this.vowels = vowels;
    }

    public void setWordLen(Integer wordLen) {
        this.wordLen = wordLen;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    @Override //({a, o}, 6) -> 2.5
    public String toString() {
        return "({" + vowels + "}," + wordLen + ") -> " + average;
    }
}
