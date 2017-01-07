package org.avg.vowels.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class VowelsInWord implements Comparable<VowelsInWord> {

    private Set<Vowel> vowels;
    private Integer wordLen;
    private Double average;

    private int total;

    public VowelsInWord() {
        vowels = new HashSet<>();
        wordLen = 0;
        average = 0.0;
        total = 0;
    }

    public void incrementTotal() {
        total++;
    }

    public int getTotal() {
        return total;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VowelsInWord that = (VowelsInWord) o;

        if (!vowels.equals(that.vowels)) return false;
        return wordLen.equals(that.wordLen);

    }

    @Override
    public int hashCode() {
        int result = vowels.hashCode();
        result = 31 * result + wordLen.hashCode();
        return result;
    }

    @Override
    public int compareTo(VowelsInWord vowelsInWord) {
        return vowelsInWord.getWordLen() - this.wordLen;
    }

}
