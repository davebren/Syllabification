package com.eski.spanish.model.language.syllabifier;

import java.util.LinkedList;
import java.util.List;

public class Syllabifier {

    private static String DIVIDER_SYMBOL = "·";

    public static String convert(String input) {
        List<String> syllables = new LinkedList<String>();
        syllables.add(input);
        return dottify(syllables);
    }
    private static void vcv(List<String> input) {
       List<String> output = new LinkedList<String>();
       for (String s : input) {

       }
    }

    private static String dottify(List<String> syllables) {
        StringBuilder sb = new StringBuilder();
        for (String syllable : syllables) {
            sb.append(syllable);
            sb.append("·");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    public static void setDividerSymbol(String dividerSymbol) {
        DIVIDER_SYMBOL = dividerSymbol;
    }
    public static String getDividerSymbol() {
        return DIVIDER_SYMBOL;
    }



}
