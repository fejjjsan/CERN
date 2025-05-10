package com.exercises.first;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DuplicateFinder {
    public static <T> List<T> findDuplicates(List<T> list) {
        Map<T, Integer> temp = new LinkedHashMap<>();

        for (T obj: list){
            temp.put(obj, temp.getOrDefault(obj, 0) + 1);
        }

        List<T> result = new ArrayList<>();

        for (T obj: temp.keySet()) {
            if (temp.get(obj) > 1) {
                result.add(obj);
            }
        }

        return result;
    }
}
