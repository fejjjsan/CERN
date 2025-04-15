package com.exercises.third;

import com.exercises.third.core.DependencyGraph;
import com.exercises.third.view.PrettyStringView;
import org.junit.Assert;
import org.junit.Test;

public class DependencyGraphTest {

    private static final String DEPENDENCIES_FILE = "dependencies.json";
    private static final String CYCLICAL_DEPENDENCIES_FILE = "cyclical-dependencies.json";

    @Test
    public void Returns_pretty_string_view_from_dependencies_graph() {
        var dependencyGraph = new DependencyGraph(new PrettyStringView());
        var roots = dependencyGraph.buildGraph(DEPENDENCIES_FILE);
        var expected = """
                - pkg1
                  - pkg2
                    - pkg3
                  - pkg3
                - pkg2
                  - pkg3
                - pkg3""";
        var actual = dependencyGraph.getView(roots);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void Returns_pretty_string_view_from_cyclical_dependencies_graph() {
        var dependencyGraph = new DependencyGraph(new PrettyStringView());
        var roots = dependencyGraph.buildGraph(CYCLICAL_DEPENDENCIES_FILE);
        var expected = """
                - pkg1
                  - pkg2
                - pkg2
                  - pkg1""";
        var actual = dependencyGraph.getView(roots);
        Assert.assertEquals(expected, actual);
    }

}
