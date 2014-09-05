package com.eski.spanish.model.language.syllabifier.cluster;

public class Cluster {

    public String chars;
    ClusterClass _class;

    public Cluster(char a) {
        chars = "" + a;
        classify();
    }
    public Cluster(char a, char b) {
        chars = a + "" +  b;
        _class = ClusterClass.CONSONANT;
    }
    public ClusterClass getClusterClass() {
        return _class;
    }
    public String toString() {
        return chars;
    }
    private void classify() {
        if (isHardVowel(chars.charAt(0))) _class = ClusterClass.HARD_VOWEL;
        else if (isSoftVowel(chars.charAt(0))) _class = ClusterClass.SOFT_VOWEL;
        else _class = ClusterClass.CONSONANT;
    }
    private static boolean isVowel(char c) {
        return isHardVowel(c) || isSoftVowel(c);
    }
    private static boolean isHardVowel(char c) {
        return
                c == 'a' ||
                        c == 'A' ||
                        c == 'á' ||
                        c == 'Á' ||
                        c == 'e' ||
                        c == 'E' ||
                        c == 'é' ||
                        c == 'É' ||
                        c == 'o' ||
                        c == 'O' ||
                        c == 'ó' ||
                        c == 'Ó' ||
                        c == 'ú' ||
                        c == 'Ú' ||
                        c == 'ü' ||
                        c == 'Ü' ||
                        c == 'í' ||
                        c == 'Í'
                ;
    }
    private static boolean isSoftVowel(char c) {
        return
                c == 'i' ||
                        c == 'u' ||
                        c == 'I' ||
                        c == 'U'
                ;
    }
}
