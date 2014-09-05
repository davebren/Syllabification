package com.eski.spanish.model.language.syllabifier;

import com.eski.spanish.model.language.syllabifier.cluster.Cluster;

import java.util.ArrayList;
import java.util.List;

public class Syllable {

    public List<Cluster> clusters;

    public Syllable(String s) {
        clusters = new ArrayList<Cluster>(s.length());
        for (int i=0; i < s.length(); i++) {
            if (paired(i, s)) {
                clusters.add(new Cluster(s.charAt(i), s.charAt(i+1)));
                i++;
            } else {
                clusters.add(new Cluster(s.charAt(i)));
            }
        }
    }
    public Syllable(List<Cluster> clusters) {
        this.clusters = clusters;
    }
    private static boolean paired(int index, String s) {
        if (index+1 >= s.length()) return false;
        char a = s.charAt(index);
        char b = s.charAt(index+1);
        return (
            ((a == 'c' || a == 'C') && (b == 'h' || b == 'H'))
            || ((a == 'l' || a == 'L') && (b == 'l' || b == 'L'))
            || ((a == 'r' || a == 'r') && (b == 'r' || b == 'R'))
        );
    }

    public String toString() {
        String s = "";
        for (Cluster cluster : clusters) s += cluster.toString();
        return s;
    }

}
