package com.exercises.second.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Office {
    public static SpreadsheetImpl newSpreadsheet(int rows, int columns) {
        return new SpreadsheetImpl(rows, columns);
    }
}
