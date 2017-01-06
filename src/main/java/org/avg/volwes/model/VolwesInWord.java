package org.avg.volwes.model;

import java.util.HashSet;
import java.util.Set;

public class VolwesInWord {

    private Set<Volwe> volwes;
    private Integer wordLen;
    private Double average;

    public VolwesInWord() {
        volwes = new HashSet<>();
        wordLen = 0;
        average = 0.0;
    }

    public void addVolwe(Volwe volwe) {
        volwes.add(volwe);
    }

    public Set<Volwe> getVolwes() {
        return volwes;
    }

    public Integer getWordLen() {
        return wordLen;
    }

    public void setVolwes(Set<Volwe> volwes) {
        this.volwes = volwes;
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
        return "({" + volwes + "}," + wordLen + ") -> " + average;
    }
}
