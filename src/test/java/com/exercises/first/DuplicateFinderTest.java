package com.exercises.first;

import com.exercises.first.DuplicateFinder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnit4.class)
public class DuplicateFinderTest {


    @Test
    public void testFindDuplicates() {
        var charList = List.of('a','d','a','b','d','c','b','f');
        var charListActual = DuplicateFinder.findDuplicates(charList);
        var charListExpected = List.of('a','d','b');

        assertThat(charListActual).isEqualTo(charListExpected);
    }

}
