package com.exercises.third.core;

import com.exercises.third.view.ViewOption;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

import static com.exercises.third.utils.PrintUtils.ioException;
import static com.exercises.third.utils.Utils.parseJson;
import static com.exercises.third.utils.Utils.readBytesFromFile;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DependencyGraph {
    private static final String RELATIVE_PATH = "src/main/resources/";
    private ViewOption viewOption;

    public DependencyGraph(ViewOption viewOption) {
        this.viewOption = viewOption;
    }

    public List<Node> buildGraph(String fileName) {
        Map<String, List<String>> dependencyMap= new HashMap<>();

        try {
            var content = readBytesFromFile(RELATIVE_PATH + fileName);
            dependencyMap = parseJson(content);
        } catch (IOException e) {
            ioException(e);
        }

        List<Node> roots = new ArrayList<>();

        for (String pkg : dependencyMap.keySet()) {
            Node root = DependencyGraph.traverseDependencies(pkg, dependencyMap, new HashSet<>());
            roots.add(root);
        }

        return roots;
    }


    private static Node traverseDependencies(String currentPkg, Map<String, List<String>> map, Set<String> visited) {
        Node node = new Node(currentPkg);
        visited.add(currentPkg);

        List<String> dependencies = map.getOrDefault(currentPkg, Collections.emptyList());
        for (String dep : dependencies) {
            if (visited.contains(dep)) {
                continue;
            }
            Node child = traverseDependencies(dep, map, new HashSet<>(visited));
            node.addChild(child);
        }

        return node;
    }

    public String getView(List<Node> roots) {
        return viewOption.getView(roots);
    }

}
