package com.exercises.second.exporter;


import com.exercises.second.core.SpreadsheetImpl;
import com.exercises.second.utils.ExporterUtils;

public class DashSpreadsheetExporter implements SpreadsheetExporter {

    private final static String DASH = "-";
    private final SpreadsheetImpl sheet;
    public DashSpreadsheetExporter(SpreadsheetImpl sheet) {
        this.sheet = sheet;
    }

    @Override
    public String export() {
        var result = new StringBuilder();
        var prefix = ExporterUtils.createPrefix(sheet);
        var sheetString = ExporterUtils.formatSheetView(sheet, DASH);
        result.append(prefix).append(sheetString);
        return result.toString();
    }
}
