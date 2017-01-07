package org.avg.vowels.model;

public enum Vowel {

    O('o'),
    A('a'),
    I('i'),
    E('e'),
    U('u'),
    Y('y');


    private Character value;

    Vowel(Character value) {
        this.value = value;
    }

    public Character getValue() {
        return value;
    }

}
