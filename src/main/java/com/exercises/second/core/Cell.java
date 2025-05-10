package com.exercises.second.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.regex.Pattern;

@Getter
@Setter
@ToString
public class Cell {
    private String value;
    private ValueType type;

    public Cell(String value) {
        this.value = value;
        this.type = determineType(value);
    }

    public static  Cell createCell(String string) {
        return new Cell(string);
    }

    private ValueType determineType(String string) {
        if (TypeChecker.isString(string)) {
            return ValueType.STRING;
        }

        if (TypeChecker.isInteger(string)) {
            return ValueType.INTEGER;
        }

        if (TypeChecker.isFormula(string)) {
            return ValueType.FORMULA;
        }

        return ValueType.NO_TYPE;
    }


    private static class TypeChecker {

        /**
         * Regular expression to validate mathematical formulas that:
         * - Always start with an equals sign ('=').
         * - Followed by a digit.
         * - Optionally contain mathematical operations (+, -, *, or /),
         *   each followed by a digit.
         * Example of valid formulas:
         * - "=4"
         * - "=4+5"
         * - "=3-2*4"
         * - "=5/2+3"
         * Example of invalid formulas:
         * - "=4++5" (invalid due to consecutive '+' operators)
         * - "=abc" (invalid, contains letters instead of numbers)
         * - "4+5" (missing '=' sign at the beginning)
         *
         */
        private final static Pattern FORMULA_PATTERN = Pattern.compile("^=\\d(?:[+\\-*/]\\d+)*");

        private static boolean isInteger(String string) {
            var trimedString = string.trim();
            if (string.startsWith("-")) {
                trimedString = string.replaceFirst("-", "");
            }

            for (char ch: trimedString.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    return false;
                }
            }
            return true;
        }

        private static boolean isString(String string) {
            var trimedString = string.trim();
            if (trimedString.isEmpty()) return true;
            if (trimedString.startsWith("=")) return false;

            for (char ch: trimedString.toCharArray()) {
                if (Character.isAlphabetic(ch) || !Character.isDigit(ch)) return true;
            }
            return false;
        }

        private static boolean isFormula(String string) {
            var trimedString = string.trim();
            if (!trimedString.startsWith("=")) {
                return false;
            }
            var noSpacesString = trimedString.replaceAll("\\s", "");
            return FORMULA_PATTERN.matcher(noSpacesString).matches();
        }

    }

}
