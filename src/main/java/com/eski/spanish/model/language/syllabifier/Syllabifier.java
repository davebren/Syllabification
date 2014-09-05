package com.eski.spanish.model.language.syllabifier;

import java.util.LinkedList;
import java.util.List;

public class Syllabifier {

    private static String DIVIDER_SYMBOL = "·";

    public static void setDividerSymbol(String dividerSymbol) {
        DIVIDER_SYMBOL = dividerSymbol;
    }
    public static String getDividerSymbol() {
        return DIVIDER_SYMBOL;
    }



}
