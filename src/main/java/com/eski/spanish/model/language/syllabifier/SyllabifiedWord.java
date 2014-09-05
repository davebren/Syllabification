package com.eski.spanish.model.language.syllabifier;

import com.eski.spanish.model.language.syllabifier.cluster.ClusterClass;

import org.apache.commons.collections4.queue.CircularFifoQueue;
import sun.rmi.runtime.Log;

import java.util.LinkedList;
import java.util.List;

public class SyllabifiedWord {

    List<Syllable> syllables;

    public SyllabifiedWord(String s) {
        syllables = new LinkedList<Syllable>();
        syllables.add(new Syllable(s));
        System.out.println(s);
        syllables = match(new ClusterClass[] {ClusterClass.VOWEL, ClusterClass.CONSONANT, ClusterClass.VOWEL}, 2);

    }
    public SyllabifiedWord(List<Syllable> syllables) {
        this.syllables = syllables;
    }
    private List<Syllable> match(ClusterClass[] target, int breakIndex) {
        List<Syllable> newSyllables = new LinkedList<Syllable>();
        CircularFifoQueue<ClusterClass> ringBuffer = new CircularFifoQueue<ClusterClass>(target.length);
        for (Syllable s : syllables) {
            //System.out.println("syllable: " + s);
            ClusterClass[] classes = new ClusterClass[target.length];
            List<Syllable> brokenSyllables = new LinkedList<Syllable>();
            ringBuffer.clear();
            int lastBrokenIndex = 0;
            for (int i=0; i < s.clusters.size(); i++) {
                //System.out.println("cluster : " + s.clusters.get(i));
                ringBuffer.add(s.clusters.get(i).getClusterClass());
                if (ringBuffer.size() < target.length) continue;

                if (match(ringBuffer, target)) {
                    brokenSyllables.add(new Syllable(s.clusters.subList(lastBrokenIndex, lastBrokenIndex+breakIndex)));
                    lastBrokenIndex = lastBrokenIndex+breakIndex;
                }
            }
            if (brokenSyllables.size() == 0) newSyllables.add(s);
            else {
                newSyllables.addAll(brokenSyllables);
                newSyllables.add(new Syllable(s.clusters.subList(lastBrokenIndex, s.clusters.size())));
            }
        }
        return newSyllables;
    }
    private boolean match(CircularFifoQueue<ClusterClass> ringBuffer, ClusterClass[] target) {
        String s = "";
        String t = "";
        for (ClusterClass c : ringBuffer) s += c + ", ";
        for (ClusterClass c : target) t += c + ", ";
        //System.out.println("match: " + s + " --- " + t);
        for (int i=0; i < target.length; i++) {
            if (!target[i].equalsX(ringBuffer.get(i))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SyllabifiedWord s = new SyllabifiedWord("chocolate");
        for (Syllable syllable : s.syllables) System.out.println(syllable.toString());
        System.out.println(s.syllables.size());
        SyllabifiedWord t = new SyllabifiedWord("chocolate");

    }

}
