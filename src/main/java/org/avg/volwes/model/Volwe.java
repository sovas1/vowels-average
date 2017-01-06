package org.avg.volwes.model;

public enum  Volwe {

    O('o'),
    A('a'),
    I('i'),
    E('e'),
    U('u'),
    Y('y');


    private Character value;

    Volwe(Character value) {
        this.value = value;
    }

    public Character getValue() {
        return value;
    }

}
