package com.exercises.second.utils;

import com.exercises.second.core.Cell;
import com.exercises.second.core.ValueType;

public class ViewFormatUtils {
    public static String formatBasedOnType(Cell cell) {
        return cell.getType() == ValueType.INTEGER ? cell.getValue().trim() : cell.getValue();
    }
}
