package com.eski.spanish.model.language.syllabifier;

import com.eski.spanish.model.language.syllabifier.cluster.Cluster;

import java.util.ArrayList;
import java.util.LinkedList;
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
    // bl, br, cl, cr, dr, fl, fr, gl, gr, pl, pr, tr
    public Syllable(List<Cluster> clusters) {
        this.clusters = clusters;
    }
    public Syllable(Cluster cluster) {
        clusters = new LinkedList<Cluster>();
        clusters.add(cluster);
    }
    private static boolean paired(int index, String s) {
        if (index+1 >= s.length()) return false;
        char a = s.charAt(index);
        char b = s.charAt(index+1);
        return (
            ((a == 'c' || a == 'C') && (b == 'h' || b == 'H'))
            || ((a == 'l' || a == 'L') && (b == 'l' || b == 'L'))
            || ((a == 'r' || a == 'R') && (b == 'r' || b == 'R'))
            || ((a == 'b' || a == 'B') && (b == 'l' || b == 'L'))
            || ((a == 'b' || a == 'B') && (b == 'r' || b == 'R'))
            || ((a == 'c' || a == 'C') && (b == 'l' || b == 'L'))
            || ((a == 'c' || a == 'C') && (b == 'r' || b == 'R'))
            || ((a == 'd' || a == 'D') && (b == 'r' || b == 'R'))
            || ((a == 'f' || a == 'F') && (b == 'l' || b == 'L' || b == 'r' || b == 'R'))
            || ((a == 'g' || a == 'G') && (b == 'l' || b == 'L' || b == 'r' || b == 'R'))
            || ((a == 'p' || a == 'P') && (b == 'l' || b == 'L' || b == 'r' || b == 'R'))
            || ((a == 't' || a == 'T') && (b == 'r' || b == 'R'))
        );
    }

    public String toString() {
        String s = "";
        for (Cluster cluster : clusters) s += cluster.toString();
        return s;
    }

}
