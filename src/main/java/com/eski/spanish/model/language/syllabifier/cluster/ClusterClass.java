package com.eski.spanish.model.language.syllabifier.cluster;

public enum ClusterClass {
    HARD_VOWEL, SOFT_VOWEL, VOWEL, CONSONANT;

    public boolean equalsX(ClusterClass _class) {
        if (_class == this) return true;
        else if (_class == VOWEL && (this == HARD_VOWEL || this == SOFT_VOWEL)) return true;
        else if (this == VOWEL && (_class == HARD_VOWEL || _class == SOFT_VOWEL)) return true;
        return false;
    }
    public String toString() {
        if (this == HARD_VOWEL) return "hard vowel";
        else if (this == SOFT_VOWEL) return "soft vowel";
        else if (this == VOWEL) return "vowel";
        else return "consonant";
    }
}
