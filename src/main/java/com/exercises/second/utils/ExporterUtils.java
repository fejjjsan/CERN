package com.exercises.second.utils;


import com.exercises.second.core.SpreadsheetImpl;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExporterUtils {
    public static String formatSheetView(SpreadsheetImpl sheet, String delimiter) {
        var rows = sheet.getRows();
        var columns = sheet.getColumns();
        var table = sheet.getSheet();

        var result = new StringBuilder();

        for (var i = 0; i < rows; i++){
            for (var j = 0; j < columns; j++) {
                var cell = table[i][j];
                if (cell.getValue().isEmpty()) {
                    result.append(delimiter);
                } else {
                    result.append(cell.getValue()).append(delimiter);
                }
            }
        }
        return result.toString();
    }


    public static String createPrefix(SpreadsheetImpl sheet) {
        var result = new StringBuilder();
        var rows = sheet.getRows();
        var columns = sheet.getColumns();
        result.append(rows).append(",").append(columns).append("#");
        return result.toString();
    }
}
