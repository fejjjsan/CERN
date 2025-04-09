package com.exercises.second.core;

import com.exercises.second.utils.ViewFormatUtils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpreadsheetImpl  {

    private final static String EMPTY_CELL = "";

    public final int rows;
    public final int columns;
    public Cell[][] sheet;

    public SpreadsheetImpl(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.sheet = new Cell[rows][columns];
        populateEmpty();
    }

    public void put(int row, int column, String value) {
        sheet[row][column] = Cell.createCell(value);
    }

    public String get(int row, int column) {
        var cell = sheet[row][column];
        return ViewFormatUtils.formatBasedOnType(cell);
    }

    public ValueType getValueType(int row, int column) {
        var cell = sheet[row][column];
        return cell.getType();
    }

    private void populateEmpty() {
        for (var i = 0; i < rows; i++){
            for (var j = 0; j < columns; j++) {
                sheet[i][j] = Cell.createCell(EMPTY_CELL);
            }
        }
    }

}
