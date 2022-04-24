package com.imc.game;

import com.imc.model.Symbol;

/**
 * Game core logics
 */
public class GameEngine {

    /**
     * Get winning symbol from two symbols.
     * @param s1
     * @param s2
     * @return  null if two symbols are the same
     */
    public static Symbol getWinningSymbol(Symbol s1, Symbol s2) {
        if (s1 == s2) {
            return null;
        }

        if (s1.beats(s2)) {
            return s1;
        } else {
            return s2;
        }
    }
}
