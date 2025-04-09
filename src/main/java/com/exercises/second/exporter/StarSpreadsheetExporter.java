package com.exercises.second.exporter;

import com.exercises.second.core.SpreadsheetImpl;
import com.exercises.second.utils.ExporterUtils;

public class StarSpreadsheetExporter implements SpreadsheetExporter {

    private final static String STAR = "*";
    private final SpreadsheetImpl sheet;
    public StarSpreadsheetExporter(SpreadsheetImpl sheet) {
        this.sheet = sheet;
    }

    @Override
    public String export() {
        var result = new StringBuilder();
        var prefix = ExporterUtils.createPrefix(sheet);
        var sheetString = ExporterUtils.formatSheetView(sheet, STAR);
        result.append(prefix).append(sheetString);
        return result.toString();
    }
}
