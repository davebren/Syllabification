package com.eski.spanish.model.language.syllabifier;

import com.eski.spanish.model.language.syllabifier.cluster.Cluster;
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
        syllables = match(new ClusterClass[] {ClusterClass.VOWEL, ClusterClass.CONSONANT, ClusterClass.VOWEL}, 1);
        syllables = match(new ClusterClass[] {ClusterClass.VOWEL, ClusterClass.CONSONANT, ClusterClass.CONSONANT, ClusterClass.VOWEL}, 1);
        syllables = match(new ClusterClass[] {ClusterClass.VOWEL, ClusterClass.CONSONANT, ClusterClass.CONSONANT, ClusterClass.CONSONANT, ClusterClass.VOWEL} , 1);
        syllables = match(new ClusterClass[] {ClusterClass.VOWEL, ClusterClass.CONSONANT, ClusterClass.CONSONANT, ClusterClass.CONSONANT, ClusterClass.CONSONANT, ClusterClass.VOWEL}, 1);
        syllables = match(new ClusterClass[] {ClusterClass.HARD_VOWEL, ClusterClass.HARD_VOWEL}, 0);
    }
    public SyllabifiedWord(List<Syllable> syllables) {
        this.syllables = syllables;
    }
    private List<Syllable> match(ClusterClass[] target, int negativeOffsetToBreak) {
        List<Syllable> newSyllables = new LinkedList<Syllable>();
        CircularFifoQueue<ClusterClass> ringBuffer = new CircularFifoQueue<ClusterClass>(target.length);
        for (Syllable s : syllables) {
            List<Syllable> brokenSyllables = new LinkedList<Syllable>();
            ringBuffer.clear();
            int lastBrokenIndex = 0;
            for (int i=0; i < s.clusters.size(); i++) {
                ringBuffer.add(s.clusters.get(i).getClusterClass());
                if (ringBuffer.size() < target.length) continue;
                if (match(ringBuffer, target)) {
                    brokenSyllables.add(new Syllable(s.clusters.subList(lastBrokenIndex, i - negativeOffsetToBreak)));
                    lastBrokenIndex = i - negativeOffsetToBreak;
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
        for (int i=0; i < target.length; i++) {
            if (!target[i].equalsX(ringBuffer.get(i))) return false;
        }
        return true;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Syllable syllable : syllables) {
            sb.append(syllable);
            sb.append(Syllabifier.getDividerSymbol());
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
